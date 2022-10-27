package com.TDAF;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalTime;

public class RecordPayment {
    private static JFrame frame = new JFrame("RECORD PAYMENT");
    private JTextField SearchBar;
    private JTextArea jobDetails;
    private JButton cardPaymentButton;
    private JButton recordCardPaymentButton;
    private JButton backButton;
    private JButton searchButton;
    private JPanel RecordPaymentLabel;
    private JButton recordCashPaymentButton;
    private user Logged_in;
    private int jobID;
    private int customerID;
    private float thisPrice;

    public user getLoggedin() {
        return this.Logged_in;
    }
//window which allows a user to record a payment for a specific job, and tie it to a customer in the system. Reworked by Joe after adapting Tayo's old version for local db. Reworked by Tayo to fix bugs/errors
    public RecordPayment(user loggedin) {
        this.Logged_in=loggedin;
        recordCardPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CardPayment paycard = new CardPayment(Logged_in,jobID,thisPrice,customerID);
                paycard.main();
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
        recordCashPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashPay();
                Receptionist receptionist = new Receptionist(Logged_in);
                receptionist.main();
                frame.dispose();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobDetails.setText(" ");
                searchforJob();
            }
        });
    }
    public void CashPay(){
        //creates a connection
        getConnector connector = new getConnector();
        try(Connection connection = connector.getConnection())
        {
            Statement stmt = connection.createStatement();
            PreparedStatement pst1 = connection.prepareStatement("UPDATE `job` SET `Status`= ? WHERE `jobID` ="+SearchBar.getText()+"");
            PreparedStatement pst2 = connection.prepareStatement("INSERT INTO `payment`(`paymentID`, `amount`, `date`, `type`, `customerID`, `jobID`) VALUES (?,?,?,?,?,?)");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM job Where jobID ="+SearchBar.getText() );
            ResultSet rs = stmt.executeQuery("Select MAX(paymentID) from payment");
            pst1.setString(1,"Paid");
            int new_paymentID = 0;
            while(rs.next()){new_paymentID = rs.getInt(1)+1;}
            float new_amount = this.thisPrice;
            Timestamp new_date = new Timestamp(System.currentTimeMillis());
            String new_type = "Cash";
            int new_customerID =this.customerID ;
            int new_jobID = this.jobID;
            pst2.setInt(1,new_paymentID);
            pst2.setFloat(2,new_amount);
            pst2.setTimestamp(3,new_date);
            pst2.setString(4,new_type);
            pst2.setInt(5,new_customerID);
            pst2.setInt(6,new_jobID);
            pst1.executeUpdate();
            pst2.executeUpdate();

        }catch(SQLException e) {
            System.out.println(e);
            System.out.println("HERE TEST");
        }
    }
    public void searchforJob(){

        //creates a connection
        getConnector connector = new getConnector();
        try(
                Connection connection = connector.getConnection())
        {
            //finds a job's details
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM job Where jobID ="+SearchBar.getText() );
            while (rs.next()) {
                this.jobID = rs.getInt(1);
                this.customerID = rs.getInt(10);
                this.thisPrice = rs.getFloat(3);
                jobDetails.setText("Urgency Level: "+rs.getString(2)+"\n"+"Price: "+rs.getString(3)+"\n"+"Status: "+rs.getString(4)+"\n"+"" +
                        "Deadline: "+rs.getString(5)+"\n"+"Job Description: "+rs.getString(6)+"\n"+"CompletionDate: "+rs.getString(9));
            }
            connection.close();

        }catch(
                SQLException e)

        {
            System.out.println(e);
        }

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
