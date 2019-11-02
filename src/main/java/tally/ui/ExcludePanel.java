package tally.ui;

import tally.algo.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ExcludePanel extends JPanel {
    TallyController m_controller;

    JLabel m_canListLab;
    JLabel m_canEclLab;

    JList m_totalList;
    JList m_selectList;
    DefaultListModel<ModelData> m_totalModel;
    DefaultListModel<ModelData> m_selectModel;
    ArrayList<ModelData> m_originList;

    JButton m_confirmBtn;
    JButton m_resetBtn;
    JButton m_closeBtn;

    public ExcludePanel(TallyController c) {
        m_controller = c;
        m_totalModel = new DefaultListModel<>();
        m_selectModel = new DefaultListModel<>();
        m_originList = new ArrayList<>();
        setLayout(null);
        int halfFrameWidth = TallySystem.S_WIN_SIZE_WIDTH >> 1;
        int frameHeight = TallySystem.S_WIN_SIZE_HEIGHT - 20;

        m_canListLab = new JLabel("All Candidates");
        m_canListLab.setBounds(10, 10, 180, 25);
        add(m_canListLab);

        m_canEclLab = new JLabel("Candidates to be excluded");
        m_canEclLab.setBounds(halfFrameWidth + 10, 10, 180, 25);
        add(m_canEclLab);

        JScrollPane leftScrollP = new JScrollPane();
        leftScrollP.setBounds(10, 40, halfFrameWidth - 20, frameHeight - 85);
        add(leftScrollP);
        m_totalList = new JList();
        m_totalList.addListSelectionListener(listSelectionEvent -> selectTotalItem(listSelectionEvent));
        m_totalList.setModel(m_totalModel);
        leftScrollP.setViewportView(m_totalList);

        JScrollPane rightScrollP = new JScrollPane();
        rightScrollP.setBounds(halfFrameWidth + 10, 40, halfFrameWidth - 20, frameHeight - 85);
        add(rightScrollP);
        m_selectList = new JList();
        m_selectList.addListSelectionListener(listSelectionEvent -> selectSelectItem(listSelectionEvent));
        m_selectList.setModel(m_selectModel);
        rightScrollP.setViewportView(m_selectList);

        m_confirmBtn = new JButton("Confirm");
        m_confirmBtn.setBounds(10, frameHeight - 35, 80, 25);
        m_confirmBtn.addActionListener(actionEvent -> confirmClick());
        add(m_confirmBtn);

        m_resetBtn = new JButton("Reset");
        m_resetBtn.setBounds(160, frameHeight - 35, 80, 25);
        m_resetBtn.addActionListener(actionEvent -> resetClick());
        add(m_resetBtn);

        m_closeBtn = new JButton("Close");
        m_closeBtn.setBounds(310, frameHeight - 35, 80, 25);
        m_closeBtn.addActionListener(actionEvent -> closeClick());

        add(m_closeBtn);
        setVisible(false);
    }

    public void selectTotalItem(ListSelectionEvent e) {
        if (!m_totalList.getValueIsAdjusting() || m_totalList.getSelectedValue() == null) {
            return;
        }
        ModelData setData = (ModelData) m_totalList.getSelectedValue();
        m_selectModel.addElement(setData);
        m_totalModel.removeElementAt(m_totalList.getSelectedIndex());
    }

    public void selectSelectItem(ListSelectionEvent e) {
        if (!m_selectList.getValueIsAdjusting() || m_selectList.getSelectedValue() == null) {
            return;
        }
        ModelData selData = (ModelData) m_selectList.getSelectedValue();
        if (m_totalModel.size() == 0) {
            m_totalModel.addElement(selData);
        } else {
            int count = 0;
            boolean isAdd = false;
            Enumeration<ModelData> modelEnum = m_totalModel.elements();
            while (modelEnum.hasMoreElements()) {
                ModelData tempData = modelEnum.nextElement();
                count++;
                if (tempData.index > selData.index) {
                    m_totalModel.add(count - 1, selData);
                    isAdd = true;
                    break;
                }
            }
            if (!isAdd) {
                m_totalModel.addElement(selData);
            }
        }
        m_selectModel.removeElementAt(m_selectList.getSelectedIndex());
        m_selectList.clearSelection();
    }

    public void confirmClick() {

        boolean isUpdateDbSucceed = true;
        // TODO go to db to update data
        List<Integer> excludeIdList = new ArrayList<>();
        Enumeration<ModelData> modelEnum = m_selectModel.elements();
        while (modelEnum.hasMoreElements()) {
            ModelData tempData = modelEnum.nextElement();
            excludeIdList.add(Integer.parseInt(tempData.id));
        }
        Tally.setExcludedCandidates(excludeIdList);

        if (isUpdateDbSucceed) {
            for (int i = 0; i < m_selectModel.size(); i++) {
                m_originList.remove(m_selectModel.get(i));
            }
            m_selectModel.clear();

            int option = JOptionPane.showConfirmDialog(null, "Exclude succeed. Recount?", "Confirm dialog", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                closeClick();
                System.out.println("Recounting tally ...");
                Thread newTread = new Thread(() -> {
                    Tally.tallyVotes();
                });
                newTread.start();
                // If recount succeed
                // System.out.println("Recount succeed");
            }
        }
    }

    public void resetClick() {
        m_totalModel.clear();
        for (ModelData data : m_originList) {
            m_totalModel.addElement(data);
        }
        m_selectModel.clear();
    }

    public void closeClick() {
        setVisible(false);
        m_controller.gotoOperationPanel();
    }

    public void showPanel() {
        if (m_originList.size() == 0) {
            loadData();
        }
        setVisible(true);
    }

    public void loadData() {
        // TODO get data from DB
        BallotPaper bp = Tally.ballotPaper;
        for (Party p : bp.partyList) {
            for (Candidate c : p.candidates) {
                m_originList.add(new ModelData(c.uid, c.uid.toString(), c.candidateName));
            }
        }
        for (Candidate v : bp.ungroupedCandidates) {
            m_originList.add(new ModelData(v.uid, v.uid.toString(), v.candidateName));
        }
        for (ModelData data : m_originList) {
            m_totalModel.addElement(data);
        }
        m_totalList.updateUI();

    }

    class ModelData {
        int index;
        String id;
        String name;

        ModelData(int index, String id, String name) {
            this.index = index;
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

}
