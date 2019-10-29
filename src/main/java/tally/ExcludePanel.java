package tally;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class ExcludePanel extends JPanel {
    TallyController m_controller;
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

        JScrollPane leftScrollP = new JScrollPane();
        leftScrollP.setBounds(5, 5, halfFrameWidth - 10, frameHeight - 40);
        add(leftScrollP);
        m_totalList = new JList();
        m_totalList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectTotalItem(listSelectionEvent);
            }
        });
        m_totalList.setModel(m_totalModel);
        leftScrollP.setViewportView(m_totalList);

        JScrollPane rightScrollP = new JScrollPane();
        rightScrollP.setBounds(halfFrameWidth + 5, 5, halfFrameWidth - 10, frameHeight - 40);
        add(rightScrollP);
        m_selectList = new JList();
        m_selectList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectSelectItem(listSelectionEvent);
            }
        });
        m_selectList.setModel(m_selectModel);
        rightScrollP.setViewportView(m_selectList);

        m_confirmBtn = new JButton("Confirm");
        m_confirmBtn.setBounds(10, frameHeight - 30, 80, 25);
        m_confirmBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                confirmClick();
            }
        });
        add(m_confirmBtn);

        m_resetBtn = new JButton("Reset");
        m_resetBtn.setBounds(100, frameHeight - 30, 80, 25);
        m_resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                resetClick();
            }
        });
        add(m_resetBtn);

        m_closeBtn = new JButton("Close");
        m_closeBtn.setBounds(190, frameHeight - 30, 80, 25);
        m_closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                closeClick();
            }
        });
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

        if (isUpdateDbSucceed){
            for (int i = 0; i < m_selectModel.size(); i++){
                m_originList.remove(m_selectModel.get(i));
            }
            m_selectModel.clear();
        }
    }

    public void resetClick() {
        m_totalModel.clear();
        for (ModelData data : m_originList){
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

        m_originList.add(new ModelData(0, "1111","1111"));
        m_originList.add(new ModelData(0, "2222","2222"));
        m_originList.add(new ModelData(0, "3333","3333"));
        m_originList.add(new ModelData(0, "4444","4444"));
        m_originList.add(new ModelData(0, "5555","5555"));

        for (ModelData data : m_originList){
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
