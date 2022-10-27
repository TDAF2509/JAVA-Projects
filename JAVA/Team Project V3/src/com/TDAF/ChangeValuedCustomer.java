package com.TDAF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ChangeValuedCustomer {
    private static JFrame frame = new JFrame("Change Customer Value");
    private JTextField SearchBar;
    private JButton searchButton;
    private JTextArea CurrentVal;
    private JButton setVal;
    private JButton backButton;
    private JPanel ChangeValuePanel;
    private JButton setNon;
    private String path = "./src/com/TDAF/resources/customer accounts.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private int current_customer;
    private user Logged_in;
    private boolean writing;
    Font font;
    //function created by Joe by adapting Tayos old version to JDBC compliant methods. Searches for the user with the ID entered, stores the ID of this customer if found to be accessed
    //by the buttons which alter the customer's account type.
    public void customerSearch(){
        //creates a connection
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            //finds the customer with the specific input ID
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT customerID,customerName,accountType FROM customer WHERE customerID ='"+SearchBar.getText()+"'");
            while(rs.next()){
                int cusID = rs.getInt(1);
                this.current_customer =cusID;
                String cusName = rs.getString(2);
                String cusVal = rs.getString(3);
                CurrentVal.setText("ID: "+Integer.toString(cusID)+" Name: "+cusName+" Account Type: "+cusVal);
            }



        }catch (SQLException e){
            System.out.println(e);
        }

    }
//method updates the currently selected customer's role based off the button selected by the user.
    public void valueChange(boolean y){
    //creates a connection
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            //reads the highest ID in the system to generate the ID of the new user
            Statement stmt = connection.createStatement();
            //prepares statement so that the value
            PreparedStatement pst = connection.prepareStatement("UPDATE customer SET accountType = ? WHERE customerID=?");
            if(y==true){
                pst.setString(1,"Valued");
                pst.setInt(2,this.current_customer);
                pst.executeUpdate();
            }
            else{
                pst.setString(1,"Non-Valued");
                pst.setInt(2,this.current_customer);
                pst.executeUpdate();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }



    public ChangeValuedCustomer(user loggedin) {
        this.Logged_in = loggedin;
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerSearch();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OfficeManager officeManager = new OfficeManager(Logged_in);
                officeManager.main();
                frame.dispose();
            }
        });

        setVal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueChange(true);
            }
        });
        setNon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueChange(false);
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ChangeValuedCustomer(Logged_in).ChangeValuePanel);

        frame.setVisible(true);
    }
}
