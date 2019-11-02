package tally.ui;

import tally.auth.PhysicalKeyVerification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class PhysicalKeyPanel extends JPanel {
    static final int PROGRESS_MIN = 0;
    static final int PROGRESS_MAX = 5000;

    TallyController m_controller;
    JLabel m_msgLab;

    JButton m_confirmBtn;
    JButton m_exitBtn;

    Timer t;
    JProgressBar progressBar;
    int currentProgress = 0;

    public PhysicalKeyPanel(TallyController c) {
        m_controller = c;
        // setLayout(new FlowLayout(FlowLayout.LEADING, 5,5));
        setLayout(null);
        JPanel containPanel = new JPanel();
        containPanel.setLayout(null);
        int containPaneHalfWidth = 160;
        containPanel.setBounds((TallySystem.S_WIN_SIZE_WIDTH>>1)-containPaneHalfWidth, 50, containPaneHalfWidth<<1, 100);

        m_msgLab = new JLabel("Checking physical key!");
        m_msgLab.setHorizontalAlignment(SwingConstants.CENTER);
        m_msgLab.setBounds(0, 10, containPaneHalfWidth<<1, 30);
        containPanel.add(m_msgLab);

        progressBar = new JProgressBar(PROGRESS_MIN, PROGRESS_MAX);
        progressBar.setValue(currentProgress);
        progressBar.setStringPainted(true);
        progressBar.setBounds(containPaneHalfWidth-80, 50, 160, 30);
        containPanel.add(progressBar);

        m_confirmBtn = new JButton("OK");
        m_confirmBtn.setBounds(containPaneHalfWidth-100, 50, 80, 30);
        m_confirmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                confirmClick();
            }
        });
        containPanel.add(m_confirmBtn);
        m_confirmBtn.setVisible(false);

        m_exitBtn = new JButton("Exit");
        m_exitBtn.setBounds(containPaneHalfWidth+20, 50, 80, 30);
        m_exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                exitClick();
            }
        });
        containPanel.add(m_exitBtn);
        m_exitBtn.setVisible(false);
        add(containPanel);
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
                    // System.out.println("Loading 5s ends");
                    m_msgLab.setText("Check physical key succeed! Press OK to login.");
                    m_confirmBtn.setVisible(true);
                    m_exitBtn.setVisible(true);
                    progressBar.setVisible(false);
                    cancel();
                }
            }
        }, 0, 100);
    }

}
