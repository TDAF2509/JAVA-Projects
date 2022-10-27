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

public class DeleteUserAccount{
    private static JFrame frame = new JFrame("Delete Account");
    private JTextField SearchBar;
    private JButton deleteButton;
    private JPanel DeleteUserAccountPanel;
    private JButton backButton;
    private String path = "./src/com/TDAF/resources/filename.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private Scanner reader;
    private String data;
    private String[] staff;
    private boolean writing;


    public DeleteUserAccount() {
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
        frame.setContentPane(new DeleteUserAccount().DeleteUserAccountPanel);
        frame.setVisible(true);
    }

    public void deleteUser(){
        try{
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                staff = data.split(",");
                System.out.println("HERE");
                String[] staffName = SearchBar.getText().split(" ");
                if (staff[1].equals(staffName[0]) && staff[2].equals(staffName[1])){
                    System.out.println("HERE1");
                }else{
                    fileWrite(staff,writing);
                    writing=true;
                }

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
