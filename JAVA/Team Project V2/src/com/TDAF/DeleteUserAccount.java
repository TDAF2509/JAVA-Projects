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

public class DeleteUserAccount{
    private static JFrame frame = new JFrame("Delete Account");
    private JTextField SearchBar;
    private JButton deleteButton;
    private JPanel DeleteUserAccountPanel;
    private JButton backButton;
    private JTextArea textArea1;
    private JButton searchButton;
    private String path = "./src/com/TDAF/resources/filename.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private Scanner reader;
    private String data;
    private String[] staff;
    private user Logged_in;
    private boolean writing;


    public DeleteUserAccount(user loggedin) {
        this.Logged_in = loggedin;
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
                JOptionPane.showMessageDialog(frame,"USER DELETED");
                SearchBar.setText("");
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
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM staff Where StaffID = "+SearchBar.getText());
                    while (rs.next() ) {
                        textArea1.setText(
                                "Staff id = " + rs.getString("StaffID")+"\n"+
                                "Role = " + rs.getString("role")+"\n"+
                                "Name = " + rs.getString("Name")+"\n"+
                                "Password = " + rs.getString("password")+"\n"+
                                "Email = " + rs.getString("email")+"\n");
                    }
                } catch (SQLException es) {
                    es.printStackTrace();
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

    public void deleteUser(){
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement("DELETE FROM `staff` WHERE `StaffID` = "+SearchBar.getText());
            ResultSet rs = stmt.executeQuery("SELECT MAX(StaffID) FROM staff");
            pst.executeUpdate();
            new OfficeManager(Logged_in).main();
            frame.dispose();

        }catch (SQLException e){
            System.out.println(e);
        }
    }

}
