package tally.ui;

import tally.algo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

public class OperationPanel extends JPanel {
    TallyController m_controller;
    JLabel m_welcomeLab;
    JLabel m_msgLab;
    JTextPane m_logPanel;
    JScrollPane scrollContainP;
    JButton m_validateBtn;
    JButton m_decryptBtn;
    JButton m_recountBtn;
    JButton m_excludeBtn;

    JButton m_settingBtn;
    JButton m_logoutBtn;
    JButton m_exitBtn;

    ArrayList<byte[]> evr = null;
    Key key;

    public OperationPanel(TallyController c) throws InvalidKeySpecException, NoSuchAlgorithmException {
        m_controller = c;
        setLayout(null);
        JPanel containPanel = new JPanel();
        containPanel.setLayout(null);
        containPanel.setBounds((TallySystem.S_WIN_SIZE_WIDTH>>1)-150, 10, 300, 200);

        m_welcomeLab = new JLabel("Welcome, " + Delegate.GetInstance().getUserName());
        m_welcomeLab.setHorizontalAlignment(SwingConstants.CENTER);
        m_welcomeLab.setBounds(10, 10, 250, 25);
        containPanel.add(m_welcomeLab);

        m_msgLab = new JLabel("Please select your operation.");
        m_msgLab.setHorizontalAlignment(SwingConstants.CENTER);
        m_msgLab.setBounds(10, 40, 250, 25);
        containPanel.add(m_msgLab);

        // Press vailidateBtn to check the validation of the votes and exclude invalid votes
        m_validateBtn = new JButton("Validate");
        m_validateBtn.setBounds(10, 80, 80, 25);
        m_validateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    validateClick();
                } catch (InvalidKeySpecException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        });
        containPanel.add(m_validateBtn);

        // Press decryptBtn to decrypt the vote data
        m_decryptBtn = new JButton("Decrypt");
        m_decryptBtn.setBounds(100, 80, 80, 25);
        m_decryptBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                decryptClick();
            }
        });
        containPanel.add(m_decryptBtn);

        m_excludeBtn = new JButton("Exclude");
        m_excludeBtn.setBounds(10, 120, 80, 25);
        m_excludeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                excludeClick();
            }
        });
        containPanel.add(m_excludeBtn);

        // Press recountBtn to operate recount (exclude a candidate and recount the votes)
        m_recountBtn = new JButton("Tally");
        //m_recountBtn.setBounds(10, 150, 80, 25);
        m_recountBtn.setBounds(190, 80, 80, 25);
        m_recountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                recountClick();
            }
        });
        containPanel.add(m_recountBtn);

        m_settingBtn = new JButton("Setting");
        m_settingBtn.setBounds(100, 120, 80, 25);
        m_settingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                settingClick();
            }
        });
        containPanel.add(m_settingBtn);

        m_logoutBtn = new JButton("Logout");
        m_logoutBtn.setBounds(190, 120, 80, 25);
        m_logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                logoutClick();
            }
        });
        containPanel.add(m_logoutBtn);

        m_exitBtn = new JButton("Exit");
        m_exitBtn.setBounds(190, 120, 80, 25);
        m_exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                exitClick();
            }
        });
        //containPanel.add(m_exitBtn);

        scrollContainP = new JScrollPane();
        scrollContainP.setBounds(10, 200,  TallySystem.S_WIN_SIZE_WIDTH-20,  350);
        m_logPanel = new JTextPane();
        scrollContainP.setViewportView(m_logPanel);
        scrollContainP.setAutoscrolls(true);
        add(scrollContainP);
        //leftScrollP.setViewportView(m_totalList);
        add(containPanel);
        setVisible(false);
    }

    public void validateClick() throws InvalidKeySpecException, NoSuchAlgorithmException {
        evr = EncryptedVoteRecord.readEncryptedVotesFile("EncryptedVoteRecord.dat");
        printLog("Read votes :" + evr.size());
        key = CryptoEngine.getVotePrivateKey();
        printLog("Verifying vote ...");
        Thread validateTread = new Thread(new Runnable() {
            @Override
            public void run() {
                EncryptedVoteRecord.verifyEncryptedVotes(evr, key);
                printLog("Successfully verified vote");
                TallySystem.showInfoDialog("Votes validate succeed"); }
        });
        validateTread.start();
    }

    public void decryptClick() {

//        if (!Delegate.GetInstance().getIsLogin()){
//            TallySystem.showInfoDialog("Please login first.");
//            return;
//        }
        if (evr == null){
            TallySystem.showInfoDialog("Please validate first.");
            return;
        }
        String state = Delegate.GetInstance().getOwnState();
        if (state.isBlank()){
            state = "SA";
        }
        printLog("Decrypting vote ...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                BallotPaper bp = new BallotPaper("SenateCandidates2016RandomOrder.csv", "SA");
                Tally.ballotPaper = bp;
                ArrayList<Vote> votes = EncryptedVoteRecord.decryptVotes(evr, key, bp);
                printLog("Successfully decrypted vote");
                Tally.voteList = votes;
                Tally.numCandidatesToElect = 6; //6 for half senate, 12 for full senate
                int option = JOptionPane.showConfirmDialog(null, "Decryption succeed. Tally the vote?", "Confirm dialog", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    Tally.tallyVotes();
                }
            }
        }).start();
    }

    public void recountClick() {
        // call recount();
        if (Tally.ballotPaper == null){
            TallySystem.showInfoDialog("Please decrypt first.");
            return;
        }
        Thread newTread = new Thread(() -> {
            Tally.tallyVotes();
        });
        newTread.start();
    }

    public void excludeClick() {

        if (Tally.ballotPaper == null){
            TallySystem.showInfoDialog("Please decrypt first.");
        }else{
            m_controller.gotoExcludePanel();
        }
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
        Tally.ballotPaper = null;
        m_controller.gotoPhysicalKeyPanel();
    }

    public void showPanel(String userName) {
        m_welcomeLab.setText("Welcome, " + userName + "!");
        this.setVisible(true);
    }
    public void printLog(String log) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String newLog = m_logPanel.getText()+"\n"+log;
                m_logPanel.setText(newLog);
            }
        });
        //m_logPanel.scrollToReference(log);
        //m_logPanel.paintImmediately(m_logPanel.getBounds());
    }

}
