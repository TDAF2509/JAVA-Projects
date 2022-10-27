package com.TDAF;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ShiftManager{
    private static JFrame frame = new JFrame("SHIFT MANAGER");
    private JButton createReportButton;
    private JButton setAutomaticReportButton;
    private JPanel shiftManagerPanel;
    private JButton logOutButton;
    private JButton receptionistButton;
    private JButton technicianButton;
    public String loggedin1;
    public static String currentlyLoggedin;
    public static Login login1;

    //Login login = new Login();
    OfficeManager officeManager = new OfficeManager();

    public String getLoggedin() {

        if (loggedin1 == "Shift Manager"){
            currentlyLoggedin.equals( "Shift Manager");
        }

        if (loggedin1 == "Office Manager"){
            currentlyLoggedin = loggedin1;
        }

        return loggedin1;
    }


    public ShiftManager(String loggedin1) {
        this.loggedin1 = loggedin1;
        if (loggedin1.equals("Shift Manager")){
            logOutButton.setText("Log Out");
            JOptionPane.showMessageDialog(frame,"HERE");
        }else{
            logOutButton.setText("Back");
            JOptionPane.showMessageDialog(frame,"HERE1");
        }

        setAutomaticReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetAutomaticReport setAutomaticReport = new SetAutomaticReport(getLoggedin());
                setAutomaticReport.main();
                frame.dispose();
            }
        });
        createReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReport createReport = new CreateReport(getLoggedin());
                createReport.main();
                frame.dispose();
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logOutButton.getText().equals("Log Out")) {
                    Login.start();
                }else{
                    officeManager.main();
                }
                frame.dispose();
            }
        });

        receptionistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Receptionist receptionist = new Receptionist(getLoggedin());
                receptionist.main();
                frame.dispose();
            }
        });
        technicianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician(getLoggedin());
                technician.main();
                frame.dispose();
            }
        });

    }


    public void main(){
        int width = 550;
        int height = 400;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ShiftManager(getLoggedin()).shiftManagerPanel);
        frame.setVisible(true);
    }


}
