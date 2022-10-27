package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CreateTaskDetail {
    private static JFrame frame = new JFrame("Create Task Detail");
    private JPanel createTaskDetailPanel;
    private JButton createTaskDetailButton;
    private JButton backButton;
    private JTextField descriptionField;
    private JTextField locationField;
    private JTextField durationField;
    private JTextField priceField;
    private user Logged_in;
//window used to create new task details which allow for new tasks to be implemented
    // into jobs in the future as BIPL advances their technologies.
    //Created by Joe (GUI and code)
    public CreateTaskDetail(user loggedin) {
        this.Logged_in = loggedin;
        createTaskDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTaskDetail();
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
    //appends the task detail to the database
    public void createTaskDetail(){
        //creates a connection
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            //reads the highest ID in the system to generate the ID of the new user
            Statement stmt = connection.createStatement();
            //prepares statement to input values from the text fields in the form.
            PreparedStatement pst = connection.prepareStatement("INSERT INTO taskdetails (task_detailID,price,description,location,duration) VALUES (?,?,?,?,?)");
            ResultSet rs = stmt.executeQuery("SELECT MAX(task_detailID) FROM taskdetails");
            int new_ID = 0;
            while(rs.next()){new_ID = rs.getInt(1)+1;}
            pst.setInt(1,new_ID);
            pst.setFloat(2,Float.parseFloat(priceField.getText()));
            pst.setString(3,descriptionField.getText());
            pst.setString(4,locationField.getText());
            pst.setInt(5,Integer.parseInt(durationField.getText()));
            pst.executeUpdate();
            connection.close();
            new Technician(Logged_in).main();
            frame.dispose();

        }catch (SQLException e){
            System.out.println(e);
        }

    }
    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CreateTaskDetail(Logged_in).createTaskDetailPanel);
        frame.setVisible(true);
    }
}
