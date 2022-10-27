package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Login {
    private JLabel titleLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private static JFrame frame = new JFrame("BAPERS");
    private JPanel loginPanel;
    private Scanner reader;
    private String data;
    private static int width = 550;
    private static int height = 400;
    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //method of connecting to database and logging in created by Joe, by rebuilding Tayo's version which operated on a text based local database.
                String username = usernameField.getText();
                String password = passwordField.getText();
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT Name,password,role FROM staff");
                    while (rs.next()){
                        String inputName = rs.getString(1) ;
                        String inputPassword = rs.getString(2);
                        String accRole = rs.getString(3);
                        if (inputName.equals(username) && inputPassword.equals(password)){
                            //logged in user details stored upon successful credentials matched. This will be passed as a parameter in all future windows generated. until Logged out.
                            user logged_in = new user(inputName,inputPassword,accRole);
                            //generates user role-based window limiting user access to the system and preventing from unnecessary clutter to lower level users.
                            if (accRole.equals("Office Manager")){
                                OfficeManager officeManager = new OfficeManager(logged_in);
                                officeManager.main();
                            }
                            if (accRole.equals("Receptionist")){
                                Receptionist receptionist = new Receptionist(logged_in);
                                receptionist.main();
                            }
                            if (accRole.equals("Shift Manager")){
                                ShiftManager shiftManager = new ShiftManager(logged_in);
                                shiftManager.main();
                            }
                            if (accRole.equals("Technician")){
                                Technician technician = new Technician(logged_in);
                                technician.main();
                            }
                            //disposes of the frame preventing a conflict.
                            connection.close();
                            frame.dispose();
                            break;
                        }

                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }
        });
    }

    public static Login start(){
        Login l = new Login();
        frame.setContentPane(l.loginPanel);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return l;
    }

    public static void main(String[] args) {
        Login main = start();
    }
    }

