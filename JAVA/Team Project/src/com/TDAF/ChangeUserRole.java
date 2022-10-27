package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    private String path = "./src/com/TDAF/resources/filename.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private Scanner reader;
    private String data;
    private String[] staff;
    private boolean writing;
    OfficeManager officeManager = new OfficeManager();

    public ChangeUserRole() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                officeManager.main();
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
        frame.setContentPane(new ChangeUserRole().ChangeUserRolePanel);
        frame.setVisible(true);
    }

    public void staffSearch(){



        try{
            reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                staff = data.split(",");
                String[] staffName = SearchBar.getText().split(" ");
                if (staffName[0].equals(staff[1])){
                    JOptionPane.showMessageDialog(frame,"USER FOUND");
                    CurrentRoleBar.setText(staff[0]);
                }
            }
            reader.reset();
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void roleChange(){
        try{
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                staff = data.split(",");
                System.out.println("HERE");
                String[] staffName = SearchBar.getText().split(" ");
                if (staff[1].equals(staffName[0]) && staff[2].equals(staffName[1])){
                    staff[0] = (String) SetRoleBar.getSelectedItem();
                    System.out.println("HERE1");
                }
                fileWrite(staff,writing);
                writing=true;
            }
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileWrite(String[] staff1,boolean append){
        try {
            writer = new FileWriter(path,append);
            writer.write(staff1[0] + "," + staff1[1] + "," + staff1[2] + '\n');
            writer.close();
            System.out.println((Arrays.toString(staff1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
