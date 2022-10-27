package com.TDAF;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OfficeManager {
    private static JFrame frame = new JFrame("OFFICE MANAGER");
    private JButton receptionistButton;
    private JButton technicianButton;
    private JButton shiftManagerButton;
    private JButton createUserAccountButton;
    private JButton changeUserRoleButton;
    private JButton deleteUserAccountButton;
    private JButton changeCustomerStatusButton;
    private JButton logOutButton;
    private JPanel officeManagerPanel;
    private JButton generateBackupButton;
    private JButton restoreBackupButton;
    private JButton alterBackupRateButton;


    public OfficeManager() {
        receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist receptionist = new Receptionist("Office Manager");
                receptionist.main();
                frame.dispose();
            }
        });
        technicianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician("Office Manager");
                technician.main();
                frame.dispose();
            }
        });
        shiftManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShiftManager shiftManager = new ShiftManager("Office Manager");
                shiftManager.main();
                frame.dispose();
            }
        });
        createUserAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateUserAccount createUserAccount = new CreateUserAccount();
                createUserAccount.main();
                frame.dispose();

            }
        });
        changeUserRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeUserRole changeUserRole = new ChangeUserRole();
                changeUserRole.main();
                frame.dispose();
            }
        });
        deleteUserAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteUserAccount deleteUserAccount = new DeleteUserAccount();
                deleteUserAccount.main();
                frame.dispose();
            }
        });
        changeCustomerStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeValuedCustomer changeValuedCustomer = new ChangeValuedCustomer();
                changeValuedCustomer.main();
                frame.dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.start();
                frame.dispose();

            }
        });
        generateBackupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"BACKUP GENERATED");
            }
        });
        restoreBackupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"RESTORING RECENT BACKUP");
            }
        });
        alterBackupRateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlterBackupRate alterBackupRate = new AlterBackupRate();
                alterBackupRate.main();
                frame.dispose();
            }
        });
    }

    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new OfficeManager().officeManagerPanel);
        frame.setVisible(true);
    }
}
