package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
//option window which allows a user to add a discount to a user. created by Joe
public class createDiscount {
    private static JFrame frame = new JFrame("Create Customer Discount");
    private JPanel createDiscountPanel;
    private JTextField searchbar;
    private JTextArea display;
    private JButton searchButton;
    private JButton fixedDiscButton;
    private JButton variableDiscButton;
    private JButton flexibleDiscButton;
    private JButton backButton;
    private user Logged_in;
    private int current_customer;

    public createDiscount(user loggedin) {
        this.Logged_in = loggedin;

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchforVal();
            }
        });
        fixedDiscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validationCheck() && validationCheck2()) {
                    fixedDiscount fixd = new fixedDiscount(Logged_in, current_customer);
                    fixd.main();
                    frame.dispose();
                }
            }
        });
        variableDiscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validationCheck() && validationCheck2()) {
                    variableDiscount vard = new variableDiscount(Logged_in, current_customer);
                    vard.main();
                    frame.dispose();
                }
            }
        });
        flexibleDiscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validationCheck() && validationCheck2()) {
                    flexibleDiscount flexd = new flexibleDiscount(Logged_in, current_customer);
                    flexd.main();
                    frame.dispose();
                }
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
        // Can only type numbers in the Search field
        searchbar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (!Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });
    }
    public boolean validationCheck() {
        if (searchbar.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Please enter the Staff ID");
            return false;
        }
        else { return true; }
    }

    public boolean validationCheck2() {
        if (display.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Please search the correct Staff ID");
            return false;
        }
        else { return true; }
    }

    public void searchforVal(){
        //creates a connection
        if (validationCheck() == true) {
            getConnector connector = new getConnector();
            try (
                    Connection connection = connector.getConnection()) {
                //finds customer with their
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT customerID,customerName,accountType FROM customer WHERE ((customerID = " + searchbar.getText() + ") AND accountType = 'Valued')");
                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(frame, "Customer not found or is not a valued customer");
                } else {
                    while (rs.next()) {
                        int cusID = rs.getInt(1);
                        this.current_customer = cusID;
                        String cusName = rs.getString(2);
                        String cusVal = rs.getString(3);
                        display.setText("ID: " + Integer.toString(cusID) + " Name: " + cusName + " Account Type: " + cusVal);
                    }
                }


            } catch (
                    SQLException e) {
                System.out.println(e);
            }
        }

    }
    public void main(){
        int width = 600;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new createDiscount(Logged_in).createDiscountPanel);
        frame.setVisible(true);
    }

}




