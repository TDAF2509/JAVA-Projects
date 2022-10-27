package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTask {
    private static JFrame frame = new JFrame("DELETE TASK");
    private JTextField textField1;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton backButton;
    private JPanel DeleteTaskPanel;
    public String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public DeleteTask(String loggedin) {
        this.loggedin = loggedin;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician(getLoggedin());
                technician.main();
                frame.dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DeleteTask(getLoggedin()).DeleteTaskPanel);
        frame.setVisible(true);
    }
}
