package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteTask {
    private static JFrame frame = new JFrame("DELETE TASK");
    private JTextField SearchBar;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton backButton;
    private JPanel DeleteTaskPanel;
    private JTextArea textArea1;
    public user Logged_in;

    public user getLogged_in() {
        return this.Logged_in;
    }

    public DeleteTask(user loggedin) {
        this.Logged_in = loggedin;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician(Logged_in);
                technician.main();
                frame.dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    PreparedStatement pst = connection.prepareStatement("DELETE FROM `task` WHERE `taskID` = "+SearchBar.getText());
                    ResultSet rs = stmt.executeQuery("SELECT MAX(taskID) FROM task");
                    pst.executeUpdate();
                    new OfficeManager(Logged_in).main();
                    frame.dispose();

                }catch (SQLException es){
                    System.out.println(es);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM task Where taskID = "+SearchBar.getText());
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
            }
        });

    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DeleteTask(Logged_in).DeleteTaskPanel);
        frame.setVisible(true);
    }
}
