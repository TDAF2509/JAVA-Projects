package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CreateUserAccount {
    private static JFrame frame = new JFrame();
    private JButton createAccountButton;
    private JTextField usernameTextField;
    private JComboBox Roles;
    private JTextField PasswordTextField;
    private JPanel CreateUserAccountPanel;
    private JButton backButton;

    public CreateUserAccount() {
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
                OfficeManager officeManager = new OfficeManager();
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
        frame.setContentPane(new CreateUserAccount().CreateUserAccountPanel);
        frame.setVisible(true);
    }

    public void saveStaff(){
        try{
            FileWriter writer = new FileWriter("./src/com/TDAF/resources/filename.txt",true);
            writer.write(Roles.getSelectedItem() + "," + usernameTextField.getText()+","+PasswordTextField.getText()+'\n');
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

}


