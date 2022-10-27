package com.TDAF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeValuedCustomer {
    private static JFrame frame = new JFrame("Change Customer Value");
    private JTextField SearchBar;
    private JButton searchButton;
    private JTextArea textArea1;
    private JButton setButton;
    private JButton backButton;
    private JPanel ChangeValuePanel;
    private JComboBox comboBox1;
    private JTextPane textPane1;
    private JTextArea textArea2;
    private JButton setButton1;
    private JCheckBox valuedCheckBox;
    private String path = "./src/com/TDAF/resources/customer accounts.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private Scanner reader;
    private String data;
    private String[] customer;
    private user Logged_in;
    private boolean writing;
    Font font;

    public void customerSearch(){

        try{
            reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                customer = data.split(",");
                if (SearchBar.getText().equals(customer[0])){
                    JOptionPane.showMessageDialog(frame,"USER FOUND");
                    textArea1.setText("Customer Name: "+customer[0]+'\n'+"Account No: "+customer[1]+'\n'+"Contact Name: "+customer[2]+'\n'+"Address: "+customer[3]+" , "+customer[4]+'\n'+
                            "Phone: "+customer[5]+'\n'+"Agreed Discount: "+customer[6]+'\n'+"Is Valued Customer: "+customer[7]+'\n');
                }
            }
            reader.reset();
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void valueChange(){
        try{
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                customer = data.split(",");
                System.out.println("HERE");
                customer[7] = comboBox1.getSelectedItem().toString();
                fileWrite(customer,writing);
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
            writer.write(staff1[0] + "," + staff1[1] + "," + staff1[2] + "," + staff1[3] + "," + staff1[4] + "," + staff1[5] + "," + staff1[6] + "," + staff1[7] + '\n');
            writer.close();
            System.out.println((Arrays.toString(staff1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChangeValuedCustomer(user loggedin) {
        this.Logged_in = loggedin;
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerSearch();
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

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valueChange();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ChangeValuedCustomer(Logged_in).ChangeValuePanel);

        frame.setVisible(true);
    }
}
