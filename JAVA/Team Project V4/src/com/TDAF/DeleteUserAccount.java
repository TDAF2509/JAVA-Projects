package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class DeleteUserAccount{
    private static JFrame frame = new JFrame("Delete User Account");
    private JTextField SearchBar;
    private JButton deleteButton;
    private JPanel DeleteUserAccountPanel;
    private JButton backButton;
    private JTextArea textArea1;
    private JButton searchButton;
    private user Logged_in;

    public DeleteUserAccount(user loggedin) {
        this.Logged_in = loggedin;
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
                //SearchBar.setText("");
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
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { staffSearch(); }
        });
        // Can only type numbers in the Search field
        SearchBar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (!Character.isDigit(e.getKeyChar())){
                    e.consume();
                }
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DeleteUserAccount(Logged_in).DeleteUserAccountPanel);
        frame.setVisible(true);
    }

    public boolean validationCheck() {
        if (SearchBar.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Please enter the Staff ID");
            return false;
        }

        else { return true; }
    }

    public boolean validationCheck2(){
        if(textArea1.getText().equals("")){
            JOptionPane.showMessageDialog(frame,"Please search the correct Staff ID");
            return false;
        }
        else{ return true; }
    }

    public void deleteUser(){
        if (validationCheck() && validationCheck2() == true) {
            getConnector connector = new getConnector();
            try (Connection connection = connector.getConnection()) {
                Statement stmt = connection.createStatement();
                PreparedStatement pst = connection.prepareStatement("DELETE FROM `staff` WHERE `StaffID` = " + SearchBar.getText());
                ResultSet rs = stmt.executeQuery("SELECT MAX(StaffID) FROM staff");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(frame, "STAFF ACCOUNT DELETED");
                new OfficeManager(Logged_in).main();
                frame.dispose();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void staffSearch(){
        if(validationCheck() == true) {
            getConnector connector = new getConnector();
            try (Connection connection = connector.getConnection()) {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM staff Where StaffID = " + SearchBar.getText());
                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(frame, "Staff not found");
                } else {
                    while (rs.next()) {
                        textArea1.setText(
                                "Staff id = " + rs.getString("StaffID")+"\n"+
                                        "Role = " + rs.getString("role")+"\n"+
                                        "Name = " + rs.getString("Name")+"\n"+
                                        "Password = " + rs.getString("password")+"\n"+
                                        "Email = " + rs.getString("email")+"\n");
                    }
                }
            } catch (SQLException es) {
                es.printStackTrace();
            }
        }

    }

}
