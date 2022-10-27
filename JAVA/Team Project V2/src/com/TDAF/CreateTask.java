package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CreateTask {
    private static JFrame frame = new JFrame("CREATE TASK");
    private JTextField TaskIDField;
    private JTextField CompletionDateField;
    private JTextField CompletionTimeField;
    private JTextField DepartmentField;
    private JButton createTaskButton;
    private JButton backButton;
    private JPanel CreateTaskPanel;
    private JTextField StaffIDField;
    private JTextField JobIDField;
    private JTextField StartTimeField;
    private JTextField StatusField;
    public user Logged_in;

    public user getLogged_in() {
        return this.Logged_in;
    }

    public CreateTask(user loggedin) {
        this.Logged_in = loggedin;
        createTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    PreparedStatement pst = connection.prepareStatement("INSERT INTO task (taskID,StaffID,completionDate,completionTime,department,jobID,startTime,status) VALUES (?,?,?,?,?,?,?,?)");
                    ResultSet rs = stmt.executeQuery("SELECT MAX(taskID) FROM task");
                    int new_taskID = 0;
                    while(rs.next()){new_taskID = rs.getInt(1)+1;}
                    int new_staffID = Integer.parseInt(StaffIDField.getText());
                    int new_jobID = Integer.parseInt(JobIDField.getText());
                    String new_completionDate = CompletionDateField.getText();
                    String new_completionTime = CompletionTimeField.getText();
                    String new_startTime = StartTimeField.getText();
                    String new_department = DepartmentField.getText();
                    String new_status = StatusField.getText();
                    pst.setInt(1,new_taskID);
                    pst.setInt(2,new_staffID);
                    pst.setString(3,new_completionDate);
                    pst.setString(4,new_completionTime);
                    pst.setString(5,new_department);
                    pst.setInt(6,new_jobID);
                    pst.setString(7,new_startTime);
                    pst.setString(8,new_status);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(frame,"TASK CREATED");
                    new Technician(Logged_in).main();
                    frame.dispose();

                }catch (SQLException e1){
                    System.out.println(e1);
                }
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
        frame.setContentPane(new CreateTask(Logged_in).CreateTaskPanel);
        frame.setVisible(true);
    }
}
