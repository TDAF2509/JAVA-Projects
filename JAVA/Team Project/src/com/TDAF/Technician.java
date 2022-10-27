package com.TDAF;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Technician {
    private static JFrame frame = new JFrame("TECHNICIAN");
    private JButton createTaskButton;
    private JButton viewTaskButton;
    private JButton deleteTaskButton;
    private JPanel technicianPanel;
    private JButton logOutButton;
    public String loggedin;
    Login login = new Login();

    public String getLoggedin() {
        return loggedin;
    }

    public Technician(String loggedin) {
        this.loggedin = loggedin;
        if (loggedin.equals("Technician")){
            logOutButton.setText("Log Out");
            JOptionPane.showMessageDialog(frame,"HERE");
        }else{
            logOutButton.setText("Back");
            JOptionPane.showMessageDialog(frame,"HERE1");
        }
        createTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateTask createTask = new CreateTask(getLoggedin());
                createTask.main();
                frame.dispose();
            }
        });
        viewTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTasks viewTasks = new ViewTasks(getLoggedin());
                viewTasks.main();
                frame.dispose();
            }
        });
        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTask deleteTask = new DeleteTask(getLoggedin());
                deleteTask.main();
                frame.dispose();
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logOutButton.getText().equals("Back") && loggedin.equals("Office Manager")){
                    OfficeManager officeManager = new OfficeManager();
                    officeManager.main();
                }
                if (logOutButton.getText().equals("Back") && loggedin.equals("Shift Manager")){
                    ShiftManager shiftManager = new ShiftManager(getLoggedin());
                    shiftManager.main();
                }
                if (logOutButton.getText().equals("Log Out")){
                    Login.start();
                }
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Technician(getLoggedin()).technicianPanel);
        frame.setVisible(true);
    }
}
