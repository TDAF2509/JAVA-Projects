package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeleteCustomerAccount {
    private static JFrame frame = new JFrame("DELETE CUSTOMER ACCOUNT");
    private JTextField SearchBar;
    private JButton searchButton;
    private JTextArea textArea1;
    private JButton deleteButton;
    private JButton backButton;
    private JPanel DeleteCustomerPanel;
    private user Logged_in;


    public DeleteCustomerAccount(user loggedin) {
        this.Logged_in = loggedin;
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staffSearch();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
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
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DeleteCustomerAccount(Logged_in).DeleteCustomerPanel);
        frame.setVisible(true);
    }

    public boolean validationCheck() {
        if (SearchBar.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Please enter the Customer ID");
            return false;
        }

        else { return true; }
    }

    public boolean validationCheck2(){
        if(textArea1.getText().equals("")){
            JOptionPane.showMessageDialog(frame,"Please search the correct Customer ID");
            return false;
        }
        else{ return true; }
    }

    public void deleteUser(){
        if (validationCheck() && validationCheck2() == true) {
            getConnector connector = new getConnector();
            try (Connection connection = connector.getConnection()) {
                Statement stmt = connection.createStatement();
                PreparedStatement pst = connection.prepareStatement("DELETE FROM customer,job WHERE customer.CustomerID = " + SearchBar.getText()+" AND `status` = 'Paid'");
                ResultSet rs = stmt.executeQuery("SELECT MAX(CustomerID) FROM customer");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(frame, "CUSTOMER ACCOUNT DELETED");
                new OfficeManager(Logged_in).main();
                frame.dispose();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(frame,"CUSTOMER HAS NOT PAID AND THEREFORE CANNOT BE DELETED");
                System.out.println(e);
            }
        }
    }

    public void staffSearch(){
        if(validationCheck() == true) {
            getConnector connector = new getConnector();
            try (Connection connection = connector.getConnection()) {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM customer,job Where customer.CustomerID = " + SearchBar.getText());
                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(frame, "Customer not found");
                } else {
                    while (rs.next()) {
                        textArea1.setText(
                                "Customer id = " + rs.getString("customerID")+"\n"+
                                        "Customer Name = " + rs.getString("customerName")+"\n"+
                                        "Contact Name = " + rs.getString("contactName")+"\n"+
                                        "Customer Address = " + rs.getString("customerAddress")+"\n"+
                                        "Customer Phone Number = " + rs.getString("customerPhone")+"\n"+
                                        "Customer Account Type = " + rs.getString("accountType")+"\n"+
                                        "Task Amount = " + rs.getString("taskamount")+"\n"+
                                        "Tasks Completed = " + rs.getString("amountCompleted")+"\n");
                    }
                }
            } catch (SQLException es) {
                es.printStackTrace();
            }
        }

    }

}
