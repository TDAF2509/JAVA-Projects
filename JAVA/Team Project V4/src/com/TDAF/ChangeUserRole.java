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

public class ChangeUserRole {
    private static JFrame frame = new JFrame();
    private JTextField SearchBar;
    private JTextField CurrentRoleBar;
    private JComboBox SetRoleBar;
    private JButton searchButton;
    private JButton setButton;
    private JButton backButton;
    private JPanel ChangeUserRolePanel;
    private JTextField UsernameField;
    private user Logged_in;
    public ChangeUserRole(user logged_in) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OfficeManager(Logged_in).main();
                frame.dispose();
            }
        });
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roleChange();
                JOptionPane.showMessageDialog(frame,"USER ROLE CHANGE");
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staffSearch();
            }
        });
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

    public boolean validationCheck() {
        if (SearchBar.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Please enter the Staff ID");
            return false;
        }
        else { return true; }
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ChangeUserRole(Logged_in).ChangeUserRolePanel);
        frame.setVisible(true);
    }

    public void staffSearch(){
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT role,Name FROM staff Where StaffID = "+SearchBar.getText());
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(frame, "Staff not found");
            } else {
                while (rs.next()) {
                    CurrentRoleBar.setText(rs.getString("role"));
                    UsernameField.setText(rs.getString("Name"));
                }
            }
        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    public void roleChange(){
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement("UPDATE `staff` SET `role`= ? WHERE `StaffID` ="+SearchBar.getText()+"");
            pst.setString(1,SetRoleBar.getSelectedItem().toString());
            ResultSet rs = stmt.executeQuery("Select * from`task` Where jobID ="+SearchBar.getText());
            pst.executeUpdate();
            if(UsernameField.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Please search the correct Staff ID");

            }
            else{
                JOptionPane.showMessageDialog(frame, "USER ROLE CHANGE");
                staffSearch();
            }
        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

}
