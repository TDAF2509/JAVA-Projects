package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ViewCustomerAccount {
    private static JFrame frame = new JFrame("View Customer Account");
    private JTextField SearchBar;
    private JButton searchButton;
    private JButton backButton;
    private JPanel ViewPanel;
    private JComboBox customerselection;
    private JTextField contactnamefield;
    private JTextField addressfield;
    private JTextField phoneNumber;
    private JTextField customerNamefield;
    private JButton updateCustomerButton;
    private JTextField statusField;
    private String path = "./src/com/TDAF/resources/customer accounts.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private Scanner reader;
    private String data;
    private String[] customer;
    private boolean writing;
    public user Logged_in;

    public user getLoggedin() {
        return this.Logged_in;
    }

    public ViewCustomerAccount(user loggedin) {
        this.Logged_in = loggedin;
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            Statement stmt1 = connection.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT customerID,customerName FROM customer");
            while (rs1.next()){
                customerselection.addItem("ID: "+rs1.getString("customerID")+" Name: "+rs1.getString("customerName"));
            }
        } catch (SQLException es) {
            es.printStackTrace();
        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist receptionist = new Receptionist(Logged_in);
                receptionist.main();
                frame.dispose();
            }
        });
        customerselection.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    PreparedStatement customerGrab = connection.prepareStatement("SELECT * FROM customer WHERE customerID = ?");
                    String[] customerIDsplit = customerselection.getSelectedItem().toString().split(" ");
                    int customerID = Integer.parseInt(customerIDsplit[1]);
                    customerGrab.setInt(1,customerID);
                    ResultSet Grabbed = customerGrab.executeQuery();
                    while (Grabbed.next()){
                        addressfield.setText(Grabbed.getString("customerAddress"));
                        customerNamefield.setText(Grabbed.getString("customerName"));
                        phoneNumber.setText(Grabbed.getString("customerPhone"));
                        contactnamefield.setText(Grabbed.getString("contactName"));
                        statusField.setText(Grabbed.getString("accountType"));
                    }
                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }
        });
        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    PreparedStatement customerPush = connection.prepareStatement("UPDATE customer SET customerAddress=?,customerName=?,customerPhone=?,contactName=? WHERE customerID=?");
                    String[] customerIDsplit = customerselection.getSelectedItem().toString().split(" ");
                    int customerID = Integer.parseInt(customerIDsplit[1]);
                    customerPush.setInt(5,customerID);
                    customerPush.setString(1,addressfield.getText());
                    customerPush.setString(2,customerNamefield.getText());
                    customerPush.setInt(3,Integer.parseInt(phoneNumber.getText()));
                    customerPush.setString(4,contactnamefield.getText());
                    customerPush.executeUpdate();
                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }
        });
    }

    public void main(){
        int width = 600;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ViewCustomerAccount(Logged_in).ViewPanel);
        frame.setVisible(true);
    }


}
