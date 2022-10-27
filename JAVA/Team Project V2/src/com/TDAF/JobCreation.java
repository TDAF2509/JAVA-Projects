package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class JobCreation {
    private static JFrame frame = new JFrame("Task Creation");
    private JTextField SearchBar;
    private JComboBox TaskDropdown;
    private JButton addTaskButton;
    private JTextArea textArea2;
    private JPanel TaskCreationPanel;
    private JTextArea textArea1;
    private JButton createJobButton;
    private JButton backButton;
    private JTextArea textArea3;
    private JComboBox comboBox1;
    private JComboBox UrgencyLevelDropDown;
    private float price = 0;
    private float duration =0;
    private int task1Amount = 0;
    private int task2Amount = 0;
    private int task3Amount = 0;
    private int task4Amount = 0;
    private int task5Amount = 0;
    private int task6Amount = 0;
    private int task7Amount = 0;
    private String[] customer;
    public  user Logged_in;

    public user getLoggedin() {
        return this.Logged_in;
    }

    public JobCreation(user loggedin) {
        this.Logged_in=loggedin;

        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            Statement stmt = connection.createStatement();
            Statement stmt1 = connection.createStatement();
            Statement stmt2 = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `description` FROM `taskdetails`");
            ResultSet rs1 = stmt1.executeQuery("SELECT customerID,customerName FROM customer");

            String name = "L";

            while (rs.next()){
                TaskDropdown.addItem(rs.getString("description"));
            }
            while (rs1.next()){
                comboBox1.addItem("ID: "+rs1.getString("customerID")+" Name: "+rs1.getString("customerName"));
            }
        } catch (SQLException es) {
            es.printStackTrace();
        }

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    String dropdown = TaskDropdown.getSelectedItem().toString();
                    ResultSet rs = stmt.executeQuery("SELECT price,duration FROM taskdetails WHERE description = '"+dropdown+"'");

                    while (rs.next()){
                        price += rs.getFloat("price");
                        duration += rs.getInt("duration");
                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }

                calculatingPrice();
                textArea2.setText(String.valueOf(price));
                textArea3.setText(String.valueOf(duration)+" mins");
            }
        });
        createJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (task1Amount==0 && task2Amount==0 && task3Amount==0 && task4Amount==0 && task5Amount==0 && task6Amount==0 && task7Amount==0){
                    JOptionPane.showMessageDialog(frame,"CUSTOMER NOT FOUND OR NO TASKS SELECTED");
                }else {
                    saveJob();
                    JOptionPane.showMessageDialog(frame,"JOB CREATED");
                    textArea1.setText("");
                    textArea2.setText("");
                    textArea3.setText("");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist receptionist = new Receptionist(getLoggedin());
                receptionist.main();
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JobCreation(getLoggedin()).TaskCreationPanel);
        frame.setVisible(true);
    }


    public void calculatingPrice(){

        if (TaskDropdown.getSelectedItem().equals("Use of large copy camera")){
            task1Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("Black and white film processing")){
            task2Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("Bag up")){
            task3Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("Colour film processing")){
            task4Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("Colour Transparency processing")){
            task5Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("Use of small copy camera")){
            task6Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("Mount Transparencies")){
            task7Amount++;
        }
        textArea1.setText("Task id : 1 x "+task1Amount+'\n'+"Task id : 2 x "+task2Amount+'\n'+"Task id : 3 x "+task3Amount+'\n'+"Task id : 4 x "+task4Amount+'\n'+
                "Task id : 5 x "+task5Amount+'\n'+"Task id : 6 x "+task6Amount+'\n'+"Task id : 7 x "+task7Amount);
    }

    public void saveJob(){
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            Statement stmt = connection.createStatement();
            Statement stmt1 = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement("INSERT INTO `job`(`jobID`, `UrgencyLvl`, `Price`, `Status`, `Deadline`, `jobDesc`, `taskamount`, `amountcompleted`, `completionDate`, `customerID`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ResultSet rs = stmt.executeQuery("SELECT MAX(jobID) FROM job");

            int new_ID = 0;
            while(rs.next()){new_ID = rs.getInt(1)+1;}
            String new_urgencyLvl = (String)UrgencyLevelDropDown.getSelectedItem().toString();
            int new_price = (int) price;
            String new_status = "incomplete";
            String new_deadline = "24:03:21.00";
            String new_jobdesc = "jobdescText";
            int new_taskAmount= task1Amount+task2Amount+task3Amount+task4Amount+task5Amount+task6Amount+task7Amount;
            int new_amountCompleted= 0;
            String new_completionDate = "23/03/21";
            String[] customerIDsplit = comboBox1.getSelectedItem().toString().split(" ");
            int customerID = Integer.parseInt(customerIDsplit[1]);


            pst.setInt(1,new_ID);
            pst.setString(2,new_urgencyLvl);
            pst.setInt(3,new_price);
            pst.setString(4,new_status);
            pst.setString(5,new_deadline);
            pst.setString(6,new_jobdesc);
            pst.setInt(7,new_taskAmount);
            pst.setInt(8,new_amountCompleted);
            pst.setString(9,new_completionDate);
            pst.setInt(10,customerID);
            pst.executeUpdate();
            new Receptionist(Logged_in).main();
            frame.dispose();
        }catch (SQLException es){
            System.out.println(es);
        }
    }

}
