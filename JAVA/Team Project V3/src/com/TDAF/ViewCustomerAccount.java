package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ViewCustomerAccount {
    private static JFrame frame = new JFrame("View Customer Account");
    private JTextField SearchBar;
    private JButton searchButton;
    private JTextArea textArea1;
    private JButton backButton;
    private JPanel ViewPanel;
    private String path = "./src/com/TDAF/resources/customer accounts.txt";
    private File myFile = new File(path);
    private FileWriter writer;
    private Scanner reader;
    private String data;
    private String[] customer;
    private boolean writing;
    public user Logged_in;

    public user getLoggedin() {
        return this.Logged_in;
    }

    public ViewCustomerAccount(user loggedin) {
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
                Receptionist receptionist = new Receptionist(Logged_in);
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
        frame.setContentPane(new ViewCustomerAccount(Logged_in).ViewPanel);
        frame.setVisible(true);
    }

    public void customerSearch(){

        try{
            reader = new Scanner(myFile);
            while (reader.hasNextLine()){
                data = reader.nextLine();
                customer = data.split(",");
                System.out.println(Arrays.toString(customer));
                System.out.println(Arrays.toString(customer[1].split(", ")));
                System.out.println(Arrays.toString(customer[2].split("]")));
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

}
