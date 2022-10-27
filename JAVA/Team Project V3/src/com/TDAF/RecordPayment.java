package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordPayment {
    private static JFrame frame = new JFrame("RECORD PAYMENT");
    private JTextField SearchBar;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton cardPaymentButton;
    private JButton cashPaymentButton;
    private JButton backButton;
    private JButton searchButton;
    private JPanel RecordPaymentLabel;
    public user Logged_in;

    public user getLoggedin() {
        return this.Logged_in;
    }

    public RecordPayment(user loggedin) {
        this.Logged_in=loggedin;

        cardPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPayment cardPayment = new CardPayment(Logged_in);
                cardPayment.main();
                frame.dispose();
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
        frame.setContentPane(new RecordPayment(Logged_in).RecordPaymentLabel);
        frame.setVisible(true);
    }
}
