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
    public String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public RecordPayment(String loggedin) {
        this.loggedin=loggedin;

        cardPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPayment cardPayment = new CardPayment(getLoggedin());
                cardPayment.main();
                frame.dispose();
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
        frame.setContentPane(new RecordPayment(getLoggedin()).RecordPaymentLabel);
        frame.setVisible(true);
    }
}
