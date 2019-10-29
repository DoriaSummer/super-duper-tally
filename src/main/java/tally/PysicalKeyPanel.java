package tally;

import tally.auth.PhysicalKeyVerification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Timer;
import java.util.TimerTask;

public class PysicalKeyPanel extends JPanel {
    static final int PROGRESS_MIN = 0;
    static final int PROGRESS_MAX = 5000;

    TallyController m_controller;
    JLabel m_msgLab;

    JButton m_confirmBtn;
    JButton m_exitBtn;

    Timer t;
    JProgressBar progressBar;
    int currentProgress = 0;

    public PysicalKeyPanel(TallyController c) {
        m_controller = c;
        // setLayout(new FlowLayout(FlowLayout.LEADING, 5,5));
        setLayout(null);
        m_msgLab = new JLabel("Checking physical key!");
        m_msgLab.setBounds(10, 20, 350, 25);
        add(m_msgLab);

        progressBar = new JProgressBar(PROGRESS_MIN, PROGRESS_MAX);
        progressBar.setValue(currentProgress);
        progressBar.setStringPainted(true);
        progressBar.setBounds(10, 55, 160, 30);
        add(progressBar);

        m_confirmBtn = new JButton("OK");
        m_confirmBtn.setBounds(10, 55, 80, 25);
        m_confirmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                confirmClick();
            }
        });
        add(m_confirmBtn);
        m_confirmBtn.setVisible(false);

        m_exitBtn = new JButton("Exit");
        m_exitBtn.setBounds(100, 55, 80, 25);
        m_exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                exitClick();
            }
        });
        add(m_exitBtn);
        m_exitBtn.setVisible(false);

        t = new Timer();
        setVisible(false);
    }

    void confirmClick() {
        // check physical device
        // boolean confirmClickInfo = false;
        // simulate physical key inserted with a timer
        m_controller.gotoLoginPanel();
    }

    void exitClick() {
        // End process
        int option = JOptionPane.showConfirmDialog(null, "Quit the system?", "Confirm dialog", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
            System.out.println("Quit confirm");
            System.exit(0);
        }
    }

    public void showPanel() {
        m_msgLab.setText("Checking physical key!");
        m_confirmBtn.setVisible(false);
        m_exitBtn.setVisible(false);
        progressBar.setVisible(false);
        currentProgress = 0;
        progressBar.setValue(currentProgress);
        this.setVisible(true);

        PhysicalKeyVerification.setPhysicalKey(getClass().getClassLoader().getResource("PhysicalKey.enc").getFile());
        PhysicalKeyVerification.genKeyPair();

        if (PhysicalKeyVerification.verifySignature()) {
            progressBar.setVisible(true);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    loading();
                }
            });
        }
    }

    public void loading() {
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isShowing()) {
                    return;
                }
                currentProgress += 100;
                progressBar.setValue(currentProgress);
                if (currentProgress >= PROGRESS_MAX) {
                    System.out.println("Loading 5s ends");
                    m_msgLab.setText("Check physical key succeed! Press OK to login.");
                    m_confirmBtn.setVisible(true);
                    m_exitBtn.setVisible(true);
                    progressBar.setVisible(false);
                    cancel();
                }
            }
        }, 0, 100);
    }

    private static String readFile(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        if (!file.exists()) {
            return "";
        }
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return "";
        }
    }


}
