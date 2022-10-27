package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewTasks {
    private static JFrame frame = new JFrame("VIEW TASKS");
    private JPanel ViewTasksPanel;
    private JTextField SearchBar;
    private JButton searchButton;
    private JTextArea textArea1;
    private JTextField CompleteTaskField;
    private JButton completeTaskButton;
    private JButton backButton;
    public user Logged_in;

    public user getLoggedin() {
        return this.Logged_in;
    }

    public ViewTasks(user loggedin) {
        this.Logged_in = loggedin;
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM task Where jobID = "+SearchBar.getText());
                    while (rs.next() ) {
                        textArea1.setText(
                                "Job ID = " + rs.getString("jobID")+"\n"+
                                        "Task ID = " + rs.getString("taskID")+"\n"+
                                        "Staff ID = " + rs.getString("StaffID")+"\n"+
                                        "Completion Date = " + rs.getString("completionDate")+"\n"+
                                        "Completion Time = " + rs.getString("completionTime")+"\n"+
                                        "Department = " + rs.getString("department")+"\n"+
                                        "Start Time = " + rs.getString("startTime")+"\n"+
                                        "Status = " + rs.getString("status")+"\n");

                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }

                JOptionPane.showMessageDialog(frame,"JOB FOUND");

            }
        });
        completeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    String done = "Completed";
                    PreparedStatement pst = connection.prepareStatement("UPDATE `task` SET `status`= ? WHERE `taskID` ="+CompleteTaskField.getText()+"");
                    pst.setString(1,"Completed");
                    ResultSet rs = stmt.executeQuery("Select * from`task` Where jobID ="+SearchBar.getText());
                    pst.executeUpdate();
                    while (rs.next() ) {
                        textArea1.setText(
                                "Job ID = " + rs.getString("jobID")+"\n"+
                                        "Task ID = " + rs.getString("taskID")+"\n"+
                                        "Staff ID = " + rs.getString("StaffID")+"\n"+
                                        "Completion Date = " + rs.getString("completionDate")+"\n"+
                                        "Completion Time = " + rs.getString("completionTime")+"\n"+
                                        "Department = " + rs.getString("department")+"\n"+
                                        "Start Time = " + rs.getString("startTime")+"\n"+
                                        "Status = " + rs.getString("status")+"\n");

                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }
                JOptionPane.showMessageDialog(frame,"TASK COMPLETED");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician(Logged_in);
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
