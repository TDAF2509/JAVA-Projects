package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTask {
    private static JFrame frame = new JFrame("CREATE TASK");
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton createTaskButton;
    private JButton backButton;
    private JPanel CreateTaskPanel;
    private JTextField textField5;
    public String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public CreateTask(String loggedin) {
        this.loggedin = loggedin;
        createTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"TASK CREATED");
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
        frame.setContentPane(new CreateTask(getLoggedin()).CreateTaskPanel);
        frame.setVisible(true);
    }
}
