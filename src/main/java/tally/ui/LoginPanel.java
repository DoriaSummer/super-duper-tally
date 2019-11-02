package tally.ui;

import tally.db.JdbcUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class LoginPanel extends JPanel {
    TallyController m_controller;
    JLabel m_msgLab;

    JLabel m_account;
    JTextField m_accText;
    JLabel m_password;
    JPasswordField m_pwdText;

    JButton m_loginBtn;
    JButton m_exitBtn;

    public LoginPanel(TallyController c) {
        m_controller = c;
        setLayout(null);
        m_msgLab = new JLabel("Welcome to Super-duper Tally System!");
        JPanel containPanel = new JPanel();
        containPanel.setLayout(null);
        containPanel.setBounds((TallySystem.S_WIN_SIZE_WIDTH>>1)-125, 50, 250, 150);
        m_msgLab.setBounds(10, 20, 250, 25);
        m_msgLab.setHorizontalAlignment(SwingConstants.CENTER);
        containPanel.add(m_msgLab);

        m_account = new JLabel("Account: ");
        m_account.setBounds(10, 50, 80, 25);
        containPanel.add(m_account);

        m_accText = new JTextField(10);
        m_accText.setBounds(120, 50, 100, 25);
        containPanel.add(m_accText);

        m_password = new JLabel("Password: ");
        m_password.setBounds(10, 80, 80, 25);
        containPanel.add(m_password);

        m_pwdText = new JPasswordField(10);
        m_pwdText.setBounds(120, 80, 100, 25);
        containPanel.add(m_pwdText);


        m_loginBtn = new JButton("Login");
        m_loginBtn.setBounds(10, 110, 80, 25);
        m_loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                loginClick();
            }
        });
        containPanel.add(m_loginBtn);

        m_exitBtn = new JButton("Exit");
        m_exitBtn.setBounds(140, 110, 80, 25);
        m_exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                exitClick();
            }
        });
        containPanel.add(m_exitBtn);
        add(containPanel);
        setVisible(false);
    }

    void loginClick() {
        String account = m_accText.getText();
        String password = new String(m_pwdText.getPassword());

        // validate input
        if (!CommonUtil.CheckAccount(account)) {
            TallySystem.showErrorDialog("Account invalid");
            return;
        }
        if (!CommonUtil.CheckPassword(password)) {
            TallySystem.showErrorDialog("Password invalid");
            return;
        }
        JdbcUtil db = JdbcUtil.GetInstance();
        password = JdbcUtil.GenerateMd5(account + password);
        String sqlStr = "SELECT *" +
                " FROM delegate" +
                " WHERE delegate_name = ?" +
                " AND delegate_pwd = ?";

        List<Map<String, Object>> resList = db.executeQuery(sqlStr, account, password);
        if (resList.size() == 0) {
            // System.out.println("res:" + resList);
            TallySystem.showInfoDialog("Incorrect account or password");
            // return;
        } else {
            TallySystem.showInfoDialog("Login succeed");
            Delegate.GetInstance().login("", account, "");
            // set the user's state, need to be updated from DB
            Delegate.GetInstance().setOwnState("SA");
            m_accText.setText("");
            m_pwdText.setText("");
            m_controller.gotoOperationPanel();
        }
        db.closeAll();
    }

    void exitClick() {
        // End process
        int option = JOptionPane.showConfirmDialog(null, "Quit the system?", "Confirm dialog", JOptionPane.YES_NO_OPTION);
        if (option == 0){
            System.out.println("Quit confirm");
            System.exit(0);
        }
    }
}
