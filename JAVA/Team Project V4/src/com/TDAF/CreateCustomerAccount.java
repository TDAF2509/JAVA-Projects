package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CreateCustomerAccount {
    private static JFrame frame = new JFrame("Customer Creator");
    private JPanel CustomerCreation;
    private JTextField CustomerNameField;
    private JTextField ContactNameField;
    private JTextField AddressField;
    private JTextField PhoneField;
    private JButton backButton;
    private JButton createCustomerButton;

    public user Logged_in;

    public user getLoggedin() {
        return this.Logged_in;
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CreateCustomerAccount(Logged_in).CustomerCreation);
        frame.setVisible(true);
    }

    public CreateCustomerAccount(user loggedin) {
        this.Logged_in = loggedin;
        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validationCheck() == true){
                    saveCustomer();
                }
                CustomerNameField.setText("");
                AddressField.setText("");
                ContactNameField.setText("");
                PhoneField.setText("");
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
        // Can only type numbers in the Phone Number field
        PhoneField.addKeyListener(new KeyAdapter() {
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
        if (CustomerNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Customer name needs at least 1 character");
            return false;
        }
        else if(AddressField.getText().equals("")){
            JOptionPane.showMessageDialog(frame,"Address needs at least 1 character");
            return false;
        }
        else if (ContactNameField.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Contact Name needs at least 1 character");
            return false;
        }
        else if (PhoneField.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Phone Number needs at least 1 number");
            return false;
        }
        else { return true; }
    }
    //method to create a new customer account in the database, to charge jobs to.
    //original method written by Tayo, new method with MySQL database integration written by Joe
    public void saveCustomer(){
        //creates a connection
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            //reads the highest ID in the system to generate the ID of the new user
            Statement stmt = connection.createStatement();
            //prepares statement to input values from the text fields in the form.
            PreparedStatement pst = connection.prepareStatement("INSERT INTO customer (customerID,customerName,contactName,customerAddress,customerPhone,accountType) VALUES (?,?,?,?,?,?)");
            ResultSet rs = stmt.executeQuery("SELECT MAX(customerID) FROM customer");
            int new_ID = 0;
            while(rs.next()){new_ID = rs.getInt(1)+1;}
            pst.setInt(1,new_ID);
            pst.setString(2,CustomerNameField.getText());
            pst.setString(3, ContactNameField.getText());
            pst.setString(4, AddressField.getText());
            pst.setString(5,PhoneField.getText());
            pst.setString(6,"Non-Valued");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(frame,"CUSTOMER CREATED");
            connection.close();
            new Receptionist(Logged_in).main();
            frame.dispose();

        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
