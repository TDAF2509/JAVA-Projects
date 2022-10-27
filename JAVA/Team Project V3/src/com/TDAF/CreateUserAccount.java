package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CreateUserAccount {
    private static JFrame frame = new JFrame();
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
                saveStaff();
                JOptionPane.showMessageDialog(frame,"USER CREATED");
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
            while(rs.next()){new_ID = rs.getInt(1)+1;}
            pst.setInt(1,new_ID);
            pst.setString(2,usernameTextField.getText());
            pst.setString(3,EmailTextField.getText());
            pst.setString(4,PasswordTextField.getText());
            pst.setString(5,(String)Roles.getSelectedItem());
            pst.executeUpdate();
            connection.close();
            new OfficeManager(Logged_in).main();
            frame.dispose();

        }catch (SQLException e){
            System.out.println(e);
        }
    }

}


