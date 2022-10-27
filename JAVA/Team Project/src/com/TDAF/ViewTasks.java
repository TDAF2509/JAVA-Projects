package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTasks {
    private static JFrame frame = new JFrame("VIEW TASKS");
    private JPanel ViewTasksPanel;
    private JTextField textField1;
    private JButton searchButton;
    private JTextArea textArea1;
    private JTextField textField2;
    private JButton completeTaskButton;
    private JButton backButton;
    public String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public ViewTasks(String loggedin) {
        this.loggedin = loggedin;
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"JOB FOUND");
            }
        });
        completeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"TASK COMPLETED");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician(getLoggedin());
                technician.main();
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ViewTasks(getLoggedin()).ViewTasksPanel);
        frame.setVisible(true);
    }
}
