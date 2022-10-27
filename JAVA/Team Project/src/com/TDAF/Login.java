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
    private String path = "./src/com/TDAF/resources/filename.txt";
    private File myFile = new File(path);
    private Scanner reader;
    private String data;
    private static int width = 550;
    private static int height = 400;
    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                GetConnector connector = new GetConnector();
                try (Connection connection = connector.GetConnection()) {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT Name,password,role FROM staff");
                    /*while (rs.next()) {
                        System.out.println("name = " + rs.getString("Name"));
                        System.out.println("password = " + rs.getString("password"));
                    }*/
                    while (rs.next()){
                        String inputName = rs.getString(1) ;
                        String inputPassword = rs.getString(2);
                        String accRole = rs.getString(3);
                        if (inputName.equals(username) && inputPassword.equals(password)){


                            if (accRole.equals("Office Manager")){
                                OfficeManager officeManager = new OfficeManager();
                                officeManager.main();
                            }
                            if (accRole.equals("Receptionist")){
                                Receptionist receptionist = new Receptionist(accRole);
                                receptionist.main();
                            }
                            if (accRole.equals("Shift Manager")){
                                ShiftManager shiftManager = new ShiftManager(accRole);
                                shiftManager.main();
                            }
                            if (accRole.equals("Technician")){
                                Technician technician = new Technician(accRole);
                                technician.main();
                            }



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
        /*getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            main.setConnection(connection);
            // do something with the connection.
            Statement stmt = main.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                System.out.println("Code = " + rs.getString("customerName"));
                System.out.println("Name = " + rs.getString("contactName"));
            }
            if(stmt !=null){stmt.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
