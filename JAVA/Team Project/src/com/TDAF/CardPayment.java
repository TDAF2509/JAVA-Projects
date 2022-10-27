package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPayment {
    private static JFrame frame = new JFrame("CARD PAYMENT");
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton submitPaymentButton;
    private JButton backButton;
    private JPanel CardPaymentPanel;
    public String loggedin;

    public String getLoggedin() {
        return loggedin;
    }

    public CardPayment(String loggedin) {
        this.loggedin = loggedin;
        submitPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"PAYMENT MADE");
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
        frame.setContentPane(new CardPayment(getLoggedin()).CardPaymentPanel);
        frame.setVisible(true);
    }
}
