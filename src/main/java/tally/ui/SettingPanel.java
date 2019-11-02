package tally.ui;

import tally.db.JdbcUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class SettingPanel extends JPanel {

    TallyController m_controller;
    JLabel m_msgLab;
    JLabel m_oldPwdLab;
    JLabel m_newPwdLab;
    JLabel m_confirmPwdLab;

    JPasswordField m_oldPwdText;
    JPasswordField m_newPwdText;
    JPasswordField m_confirmPwdText;

    JButton m_confirmBtn;
    JButton m_cancelBtn;

    public SettingPanel(TallyController c) {

        m_controller = c;
        setLayout(null);
        JPanel containPanel = new JPanel();
        containPanel.setLayout(null);
        containPanel.setBounds((TallySystem.S_WIN_SIZE_WIDTH>>1)-160, 50, 320, 250);
        m_msgLab = new JLabel("Change password");
        m_msgLab.setBounds(10, 20, 250, 25);
        containPanel.add(m_msgLab);

        m_oldPwdLab = new JLabel("Please enter old password: ");
        m_oldPwdLab.setBounds(10, 50, 200, 25);
        containPanel.add(m_oldPwdLab);

        m_oldPwdText = new JPasswordField(10);
        m_oldPwdText.setBounds(220, 50, 100, 25);
        containPanel.add(m_oldPwdText);

        m_newPwdLab = new JLabel("Please enter new password: ");
        m_newPwdLab.setBounds(10, 80, 200, 25);
        containPanel.add(m_newPwdLab);

        m_newPwdText = new JPasswordField(10);
        m_newPwdText.setBounds(220, 80, 100, 25);
        containPanel.add(m_newPwdText);

        m_confirmPwdLab = new JLabel("Please confirm new password: ");
        m_confirmPwdLab.setBounds(10, 110, 200, 25);
        containPanel.add(m_confirmPwdLab);

        m_confirmPwdText = new JPasswordField(10);
        m_confirmPwdText.setBounds(220, 110, 100, 25);
        containPanel.add(m_confirmPwdText);


        m_confirmBtn = new JButton("Confirm");
        m_confirmBtn.setBounds(10, 150, 80, 25);
        m_confirmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                confirmClick();
            }
        });
        containPanel.add(m_confirmBtn);

        m_cancelBtn = new JButton("Cancel");
        m_cancelBtn.setBounds(140, 150, 80, 25);
        m_cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                cancelClick();
            }
        });
        containPanel.add(m_cancelBtn);
        add(containPanel);
        setVisible(false);
    }

    void confirmClick() {
        String account = Delegate.GetInstance().getUserName();

        String oldPwd = new String(m_oldPwdText.getPassword());
        String newPwd = new String(m_newPwdText.getPassword());
        String confirmPwd = new String(m_confirmPwdText.getPassword());

        if (!CommonUtil.CheckPassword(oldPwd)) {
            TallySystem.showErrorDialog("Old password invalid, please try again.");
            clearShowTxt();
            return;
        }
        // check new password validation
        if (!CommonUtil.CheckPassword(newPwd)) {
            TallySystem.showErrorDialog("New password invalid, please try again.");
            clearShowTxt();
            return;
        }

        // check consistency
        if (!confirmPwd.equals(newPwd)) {
            TallySystem.showErrorDialog("Passwords entered differently, please try again.");
            clearShowTxt();
            return;
        }

        // check old password
        JdbcUtil db = JdbcUtil.GetInstance();
        String password = JdbcUtil.GenerateMd5(account + oldPwd);
        String sqlStr = "SELECT *" +
                " FROM delegate" +
                " WHERE delegate_name = ?" +
                " AND delegate_pwd = ?";
        List<Map<String, Object>> resList = db.executeQuery(sqlStr, account, password);
        if (resList.size() == 0) {
            // System.out.println("res:" + resList);
            TallySystem.showInfoDialog("Incorrect old password, please try again.");
            clearShowTxt();
            // return;
        } else {
            // change the password
            password = JdbcUtil.GenerateMd5(account+newPwd);
            sqlStr = "UPDATE delegate SET delegate_pwd = ? WHERE delegate_name = ?";
            int res = db.executeUpdate(sqlStr, password, account);
            System.out.println("res:" + res);
            if (res == 0) {
                TallySystem.showInfoDialog("Error occurs, please try later.");
            } else {
                TallySystem.showInfoDialog("Password change succeed, please login again.");
                Delegate.GetInstance().logout();
                clearShowTxt();
                m_controller.gotoLoginPanel();
            }
        }
        db.closeAll();
    }
    private  void clearShowTxt(){
        m_oldPwdText.setText("");
        m_newPwdText.setText("");
        m_confirmPwdText.setText("");
    }

    void cancelClick() {
        clearShowTxt();
        m_controller.gotoOperationPanel();
    }

}
