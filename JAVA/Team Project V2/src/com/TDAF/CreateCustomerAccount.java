package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CreateCustomerAccount {
    private static JFrame frame = new JFrame("Customer Creator");
    private JPanel CustomerCreation;
    private JTextField CustomerIDField;
    private JTextField CustomerNameField;
    private JTextField ContactNameField;
    private JTextField AddressField;
    private JTextField PhoneField;
    private JButton backButton;
    private JButton createCustomerButton;
    private JTextField AccountTypeField;
    private JComboBox ValueDropdown;
    private JTextArea textArea1;
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
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    PreparedStatement pst = connection.prepareStatement("INSERT INTO customer (customerID,accountType,contactName,customerAddress,customerName,customerPhone) VALUES (?,?,?,?,?,?)");
                    ResultSet rs = stmt.executeQuery("SELECT MAX(customerID) FROM customer");
                    int new_ID = 0;
                    while(rs.next()){new_ID = rs.getInt(1)+1;}
                    String new_accountType = (String)AccountTypeField.getText();
                    String new_contactName = ContactNameField.getText();
                    String new_contactAddress = AddressField.getText();
                    String new_customerName = CustomerNameField.getText();
                    String new_customerPhone = PhoneField.getText();
                    pst.setInt(1,new_ID);
                    pst.setString(2,new_accountType);
                    pst.setString(3,new_customerName);
                    pst.setString(4,new_contactAddress);
                    pst.setString(5,new_customerName);
                    pst.setString(6,new_customerPhone);
                    pst.executeUpdate();
                    new Receptionist(Logged_in).main();
                    frame.dispose();
                }catch (SQLException es){
                    System.out.println(es);
                }
                JOptionPane.showMessageDialog(frame,"CUSTOMER CREATED");
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
}
