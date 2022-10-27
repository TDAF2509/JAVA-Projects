package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetAutomaticReport {
    private static JFrame frame = new JFrame("SET AUTOMATIC REPORT");
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton setButton;
    private JButton backButton;
    private JPanel SetAutomaticReportPanel;
    public String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public SetAutomaticReport(String loggedin) {
        this.loggedin=loggedin;
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"REPORT UPDATED");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShiftManager shiftManager = new ShiftManager(getLoggedin());
                shiftManager.main();
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SetAutomaticReport(getLoggedin()).SetAutomaticReportPanel);
        frame.setVisible(true);
    }
}
