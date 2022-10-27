package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SetAutomaticReport {
    private static JFrame frame = new JFrame("SET AUTOMATIC REPORT");
    private JTextArea textArea1;
    private JButton setButton;
    private JButton backButton;
    private JPanel SetAutomaticReportPanel;
    private JComboBox comboBox1;
    public user Logged_in;

    public user getLogged_in() {
        return this.Logged_in;
    }

    public SetAutomaticReport(user loggedin) {
        this.Logged_in=loggedin;
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                JOptionPane.showMessageDialog(frame,"REPORT UPDATED");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShiftManager shiftManager = new ShiftManager(Logged_in);
                shiftManager.main();
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 450;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SetAutomaticReport(Logged_in).SetAutomaticReportPanel);
        frame.setVisible(true);
    }
}
