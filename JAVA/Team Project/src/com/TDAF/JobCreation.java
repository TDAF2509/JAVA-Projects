package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JobCreation {
    private static JFrame frame = new JFrame("Task Creation");
    private JTextField SearchBar;
    private JComboBox TaskDropdown;
    private JButton addTaskButton;
    private JTextArea textArea2;
    private JPanel TaskCreationPanel;
    private JTextArea textArea1;
    private JButton createJobButton;
    private JButton backButton;
    private JTextArea textArea3;
    private JComboBox comboBox1;
    private float price = 0;
    private float duration =0;
    private int task1Amount = 0;
    private int task2Amount = 0;
    private int task3Amount = 0;
    private int task4Amount = 0;
    private int task5Amount = 0;
    private int task6Amount = 0;
    private int task7Amount = 0;
    private String path = "./src/com/TDAF/resources/customer accounts.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private Scanner reader;
    private String data;
    private String[] customer;
    public  String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public JobCreation(String loggedin) {
        this.loggedin=loggedin;

        customerSearch();

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatingPrice();
                textArea2.setText(String.valueOf(price));
                textArea3.setText(String.valueOf(duration)+" mins");
            }
        });
        createJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (task1Amount==0 && task2Amount==0 && task3Amount==0 && task4Amount==0 && task5Amount==0 && task6Amount==0 && task7Amount==0){
                    JOptionPane.showMessageDialog(frame,"CUSTOMER NOT FOUND OR NO TASKS SELECTED");
                }else {
                    saveJob();
                    JOptionPane.showMessageDialog(frame,"JOB CREATED");
                    textArea1.setText("");
                    textArea2.setText("");
                    textArea3.setText("");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist receptionist = new Receptionist(getLoggedin());
                receptionist.main();
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JobCreation(getLoggedin()).TaskCreationPanel);
        frame.setVisible(true);

    }


    public void calculatingPrice(){

        if (TaskDropdown.getSelectedItem().equals("1: Use of large copy camera")){
            price+=19;
            duration+=120;
            task1Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("2: Black and white film processing")){
            price+=49.50;
            duration+=60;
            task2Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("3: Bag up")){
            price+=6;
            duration+=30;
            task3Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("4: Colour film processing")){
            price+=80;
            duration+=90;
            task4Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("5: Colour Transparency processing")){
            price+=110.30;
            duration+=180;
            task5Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("6: Use of small copy camera")){
            price+=8.30;
            duration+=75;
            task6Amount++;
        }
        if (TaskDropdown.getSelectedItem().equals("7: Mount Transparencies")){
            price+=55.50;
            duration+=45;
            task7Amount++;
        }

        textArea1.setText("Task id : 1 x "+task1Amount+'\n'+"Task id : 2 x "+task2Amount+'\n'+"Task id : 3 x "+task3Amount+'\n'+"Task id : 4 x "+task4Amount+'\n'+
                "Task id : 5 x "+task5Amount+'\n'+"Task id : 6 x "+task6Amount+'\n'+"Task id : 7 x "+task7Amount);

    }

    public void saveJob(){
        try{
            FileWriter writer = new FileWriter("./src/com/TDAF/resources/Jobs in progress.txt",true);
            writer.write(comboBox1.getSelectedItem() + "," + textArea1.getText()+","+textArea2.getText()+","+textArea3.getText()+'\n');
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch (IOException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public void customerSearch(){

        try{
            reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                customer = data.split(",");
                comboBox1.addItem(customer[0].toString());
            }
            reader.reset();
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

}
