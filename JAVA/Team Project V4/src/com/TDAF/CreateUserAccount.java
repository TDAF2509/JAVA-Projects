package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
//window that allows new users to be made, created by Joe
public class CreateUserAccount {
    private static JFrame frame = new JFrame("Create BAPERS User");
    private JButton createAccountButton;
    private JTextField usernameTextField;
    private JComboBox Roles;
    private JTextField PasswordTextField;
    private JPanel CreateUserAccountPanel;
    private JButton backButton;
    private JTextField EmailTextField;
    private user Logged_in;

    public CreateUserAccount(user loggedin) {
        this.Logged_in = loggedin;
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validationCheck() == true) {
                    saveStaff();

                }
                usernameTextField.setText("");
                PasswordTextField.setText("");

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

    public boolean validationCheck() {
        if (usernameTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Username needs at least 1 character");
            return false;
        }
        else if (PasswordTextField.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Password needs at least 1 character");
            return false;
        }
        else if (EmailTextField.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Email needs at least 1 character");
            return false;
        }
        else { return true; }
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CreateUserAccount(Logged_in).CreateUserAccountPanel);
        frame.setVisible(true);
    }


//method of creating and adding a new user to the database created by Joe.
    public void saveStaff(){
    //creates a connection
    getConnector connector = new getConnector();
    try (Connection connection = connector.getConnection()) {
        //reads the highest ID in the system to generate the ID of the new user
        Statement stmt = connection.createStatement();
        //prepares statement to input values from the text fields in the form.
        PreparedStatement pst = connection.prepareStatement("INSERT INTO staff (StaffID,Name,email,password,role) VALUES (?,?,?,?,?)");
        ResultSet rs = stmt.executeQuery("SELECT MAX(StaffID) FROM staff");
        int new_ID = 0;
        while (rs.next()) {
            new_ID = rs.getInt(1) + 1;
        }
        pst.setInt(1, new_ID);
        pst.setString(2, usernameTextField.getText());
        pst.setString(3, EmailTextField.getText());
        pst.setString(4, PasswordTextField.getText());
        pst.setString(5, (String) Roles.getSelectedItem());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(frame, "STAFF ACCOUNT CREATED, Staff ID: " + new_ID  );
        //JOptionPane.showMessageDialog(frame, "Staff ID: " + new_ID);
        connection.close();
        new OfficeManager(Logged_in).main();
        frame.dispose();

    } catch (SQLException e) {
        System.out.println(e);
    }

}

}


