package com.TDAF;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Receptionist {
    private static JFrame frame = new JFrame("RECEPTIONIST");
    private JButton createCustomerAccountButton;
    private JButton viewCustomerAccountButton;
    private JButton createJobButton;
    private JButton recordPaymentButton;
    private JPanel receptionistPanel;
    private JButton button1;
    private String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public Receptionist(String loggedin) {
        this.loggedin = loggedin;
        if (loggedin.equals("Receptionist")){
            button1.setText("Log Out");
            JOptionPane.showMessageDialog(frame,"HERE");
        }else{
            button1.setText("Back");
            JOptionPane.showMessageDialog(frame,"HERE1");
        }

        createCustomerAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateCustomerAccount createCustomerAccount = new CreateCustomerAccount(getLoggedin());
                createCustomerAccount.main();
                frame.dispose();
            }
        });
        viewCustomerAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCustomerAccount viewCustomerAccount = new ViewCustomerAccount(getLoggedin());
                viewCustomerAccount.main();
                frame.dispose();
            }
        });
        createJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JobCreation jobCreation = new JobCreation(getLoggedin());
                jobCreation.main();
                frame.dispose();
            }
        });
        recordPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordPayment recordPayment = new RecordPayment(getLoggedin());
                recordPayment.main();
                frame.dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                OfficeManager officeManager = new OfficeManager();
                ShiftManager shiftManager = new ShiftManager(getLoggedin());
                if (button1.getText().equals("Back") && getLoggedin().equals("Office Manager")){
                    officeManager.main();
                }
                if (button1.getText().equals("Back") && getLoggedin().equals("Shift Manager")){
                    shiftManager.main();
                }
                if (button1.getText().equals("Log Out")){
                    login.start();
                }
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Receptionist(getLoggedin()).receptionistPanel);
        frame.setVisible(true);
    }
}
