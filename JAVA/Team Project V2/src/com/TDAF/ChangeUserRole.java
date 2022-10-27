package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            while (rs.next() ) {
                CurrentRoleBar.setText(rs.getString("role"));
                UsernameField.setText(rs.getString("Name"));
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
        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

}
