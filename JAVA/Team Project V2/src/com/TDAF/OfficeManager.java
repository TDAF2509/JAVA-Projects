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
    private user Logged_in;

    public OfficeManager(user logged) {
        this.Logged_in = logged;
        receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Receptionist(Logged_in).main();
                frame.dispose();
            }
        });
        technicianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician(Logged_in);
                technician.main();
                frame.dispose();
            }
        });
        shiftManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShiftManager shiftManager = new ShiftManager(Logged_in);
                shiftManager.main();
                frame.dispose();
            }
        });
        createUserAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateUserAccount createUserAccount = new CreateUserAccount(Logged_in);
                createUserAccount.main();
                frame.dispose();

            }
        });
        changeUserRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeUserRole changeUserRole = new ChangeUserRole(Logged_in);
                changeUserRole.main();
                frame.dispose();
            }
        });
        deleteUserAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteUserAccount deleteUserAccount = new DeleteUserAccount(Logged_in);
                deleteUserAccount.main();
                frame.dispose();
            }
        });
        changeCustomerStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeValuedCustomer changeValuedCustomer = new ChangeValuedCustomer(Logged_in);
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
                AlterBackupRate alterBackupRate = new AlterBackupRate(Logged_in);
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
        frame.setContentPane(new OfficeManager(Logged_in).officeManagerPanel);
        frame.setVisible(true);
    }
}
