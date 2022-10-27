package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterBackupRate {
    private static JFrame frame = new JFrame("ALTER BACKUP RATE");
    private JButton setButton;
    private JButton backButton;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JPanel AlterBackUpRatePanel;

    public AlterBackupRate() {
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"BACKUP RATE ALTERED");
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
        frame.setContentPane(new AlterBackupRate().AlterBackUpRatePanel);
        frame.setVisible(true);
    }
}
