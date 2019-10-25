package TallySystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setLayout(new FlowLayout(FlowLayout.LEADING, 5,5));
        m_msgLab = new JLabel("Please insert the physical key!");
        m_msgLab.setBounds(10, 20, 350, 25);
        add(m_msgLab);

        progressBar = new JProgressBar(PROGRESS_MIN, PROGRESS_MAX);
        progressBar.setValue(currentProgress);
        progressBar.setStringPainted(true);
        progressBar.setBounds(10, 60, 80, 30);
        add(progressBar);

        m_confirmBtn = new JButton("OK");
        m_confirmBtn.setBounds(10, 110, 80, 25);
        m_confirmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                confirmClick();
            }
        });
        add(m_confirmBtn);
        m_confirmBtn.setVisible(false);

        m_exitBtn = new JButton("Exit");
        m_exitBtn.setBounds(100, 110, 80, 25);
        m_exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                exitClick();
            }
        });
        add(m_exitBtn);
        m_exitBtn.setVisible(false);

        t = new Timer();
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
        if (option == 0){
            System.out.println("Quit confirm");
            System.exit(0);
        }
    }

    public void showPanel() {
        m_confirmBtn.setVisible(false);
        m_exitBtn.setVisible(false);
        progressBar.setVisible(true);
        currentProgress = 0;
        progressBar.setValue(currentProgress);
        this.setVisible(true);
        tick();
    }

    public void tick() {
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isShowing()){
                    return;
                }
                currentProgress+=100;
                progressBar.setValue(currentProgress);
                if (currentProgress >= PROGRESS_MAX){
                    System.out.println("5s end");
                    m_msgLab.setText("Check physical key succeed! Press ok to login.");
                    m_confirmBtn.setVisible(true);
                    m_exitBtn.setVisible(true);
                    progressBar.setVisible(false);
                    cancel();
                }
            }
        }, 0,100);
    }

}
