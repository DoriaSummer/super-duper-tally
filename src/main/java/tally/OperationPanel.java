package tally;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationPanel extends JPanel {
    TallyController m_controller;
    JLabel m_welcomeLab;
    JLabel m_msgLab;

    JButton m_validateBtn;
    JButton m_decryptBtn;
    JButton m_recountBtn;
    JButton m_excludeBtn;

    JButton m_settingBtn;
    JButton m_logoutBtn;
    JButton m_exitBtn;

    public OperationPanel(TallyController c) {
        m_controller = c;
        setLayout(null);

        m_welcomeLab = new JLabel("Welcome, " + Delegate.GetInstance().getUserName());
        m_welcomeLab.setBounds(10, 20, 250, 25);
        add(m_welcomeLab);

        m_msgLab = new JLabel("Please select your operation.");
        m_msgLab.setBounds(10, 55, 250, 25);
        add(m_msgLab);

        // Press vailidateBtn to check the validation of the votes and exclude invalid votes
        m_validateBtn = new JButton("Validate");
        m_validateBtn.setBounds(10, 100, 80, 25);
        m_validateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                validateClick();
            }
        });
        add(m_validateBtn);

        // Press decryptBtn to decrypt the vote data
        m_decryptBtn = new JButton("Decrypt");
        m_decryptBtn.setBounds(100, 100, 80, 25);
        m_decryptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                decryptClick();
            }
        });
        add(m_decryptBtn);


        m_excludeBtn = new JButton("Exclude");
        m_excludeBtn.setBounds(190, 100, 80, 25);
        m_excludeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                excludeClick();
            }
        });
        add(m_excludeBtn);

        // Press recountBtn to operate recount (exclude a candidate and recount the votes)
        m_recountBtn = new JButton("Recount");
        m_recountBtn.setBounds(190, 100, 80, 25);
        m_recountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                recountClick();
            }
        });
        //add(m_recountBtn);

        m_settingBtn = new JButton("Setting");
        m_settingBtn.setBounds(10, 145, 80, 25);
        m_settingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                settingClick();
            }
        });
        add(m_settingBtn);

        m_logoutBtn = new JButton("Logout");
        m_logoutBtn.setBounds(100, 145, 80, 25);
        m_logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                logoutClick();
            }
        });
        add(m_logoutBtn);

        m_exitBtn = new JButton("Exit");
        m_exitBtn.setBounds(190, 145, 80, 25);
        m_exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                exitClick();
            }
        });
        add(m_exitBtn);
        setVisible(false);
    }

    public void validateClick() {
        // call validate();
        TallySystem.showInfoDialog("Votes validate succeed");
    }

    public void decryptClick() {
        // call decrypt();
        TallySystem.showInfoDialog("Decryption succeed");
    }

    public void recountClick() {
        // call recount();
        TallySystem.showInfoDialog("Recount succeed");
    }

    public void excludeClick() {
        System.out.println("excludeClick");
        m_controller.gotoExcludePanel();
    }

    public void settingClick() {
        // go to setting
        m_controller.gotoSettingPanel();
    }

    void exitClick() {
        // End process
        int option = JOptionPane.showConfirmDialog(null, "Quit the system?", "Confirm dialog", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
            System.out.println("Quit confirm");
            System.exit(0);
        }
    }

    void logoutClick() {
        // clear
        TallySystem.showInfoDialog("Logout succeed");
        Delegate.GetInstance().logout();
        m_controller.gotoPhysicalKeyPanel();
    }

    public void showPanel(String userName) {
        m_welcomeLab.setText("Welcome, " + userName + "!");
        this.setVisible(true);
    }
}
