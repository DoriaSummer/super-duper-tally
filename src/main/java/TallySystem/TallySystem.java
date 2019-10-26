package TallySystem;

import javax.swing.*;
import java.awt.*;

public class TallySystem implements TallyController {
    static final int S_WIN_SIZE_WIDTH = 400;
    static final int S_WIN_SIZE_HEIGHT = 300;
    JFrame m_mainFrame;
    PysicalKeyPanel m_physicalKeyPanel;
    LoginPanel m_loginPanel;
    OperationPanel m_operationPanel;
    SettingPanel m_settingPanel;

    TallySystem() {
        initUI();
    }

    public void initUI() {

        // new frame
        JFrame.setDefaultLookAndFeelDecorated(true);
        m_mainFrame = new JFrame("Super-duper Tally System");
        // set frame size
        m_mainFrame.setPreferredSize(new Dimension(S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT));
        // set frame location at the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = ((int) screenSize.getWidth() - S_WIN_SIZE_WIDTH) >> 1;
        int y = ((int) screenSize.getHeight() - S_WIN_SIZE_HEIGHT) >> 1;
        m_mainFrame.setLocation(x, y);
        // set close window operation
        m_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initial with physical panel
        m_physicalKeyPanel = new PysicalKeyPanel(this);
        m_physicalKeyPanel.setBounds(0, 0, S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT);
        m_physicalKeyPanel.showPanel();

        // login panel
        m_loginPanel = new LoginPanel(this);
        m_loginPanel.setBounds(0, 0, S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT);
        m_loginPanel.setPreferredSize(new Dimension(S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT));
        m_loginPanel.setVisible(false);

        // operation panel
        m_operationPanel = new OperationPanel(this);
        m_operationPanel.setBounds(0, 0, S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT);
        m_operationPanel.setPreferredSize(new Dimension(S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT));
        m_operationPanel.setVisible(false);

        // setting panel
        m_settingPanel = new SettingPanel(this);
        m_settingPanel.setBounds(0, 0, S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT);
        m_settingPanel.setPreferredSize(new Dimension(S_WIN_SIZE_WIDTH, S_WIN_SIZE_HEIGHT));
        m_settingPanel.setVisible(false);

        // add panels
        m_mainFrame.add(m_physicalKeyPanel);
        m_mainFrame.add(m_loginPanel);
        m_mainFrame.add(m_operationPanel);
        m_mainFrame.add(m_settingPanel);

        // show the window
        m_mainFrame.pack();
        m_mainFrame.validate();
        m_mainFrame.setVisible(true);
    }

    public static void showInfoDialog(String msg) {
        JOptionPane.showMessageDialog(null, msg);

    }

    public static void showErrorDialog(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);

    }

    @Override
    public void gotoLoginPanel() {
        // Physical key panel invisible
        // Login panel visible
        m_physicalKeyPanel.setVisible(false);
        m_settingPanel.setVisible(false);
        m_loginPanel.setVisible(true);
    }

    @Override
    public void gotoOperationPanel() {
        // Login panel invisible
        // Setting panel invisible
        // Operate panel visible
        m_loginPanel.setVisible(false);
        m_settingPanel.setVisible(false);
        m_operationPanel.showPanel(Delegate.GetInstance().getUserName());
    }

    @Override
    public void gotoPhysicalKeyPanel() {
        // Operate panel invisible
        // Physical key panel invisible
        m_operationPanel.setVisible(false);
        m_physicalKeyPanel.showPanel();
    }

    @Override
    public void gotoSettingPanel() {
        // Operate panel invisible
        // Setting panel visible
        m_operationPanel.setVisible(false);
        m_settingPanel.setVisible(true);
    }
}
