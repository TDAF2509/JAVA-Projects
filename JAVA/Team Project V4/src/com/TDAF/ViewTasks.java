package com.TDAF;

/*import com.mysql.cj.PreparedQuery;*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewTasks {
    private static JFrame frame = new JFrame("VIEW TASKS");
    private JPanel ViewTasksPanel;
    private JTextField SearchBar;
    private JButton searchButton;
    private JTextArea taskDisplay;
    private JTextField TaskSearchField;
    private JButton completeTaskButton;
    private JButton backButton;
    private JButton beginTaskButton;
    private JButton filterCompleteJobsButton;
    private JButton removeFilterButton;
    private JButton filterIncompleteButton;
    public user Logged_in;

    public user getLoggedin() {
        return this.Logged_in;
    }

//window for displaying tasks in the system, able to filter complete, incomplete and by JobID. Written by Joe
    public ViewTasks(user loggedin) {
        this.Logged_in = loggedin;
        getConnector connector = new getConnector();
        try (Connection connection = connector.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM task ");
            while (rs.next() ) {
                taskDisplay.append(
                        "Job ID = " + rs.getString("jobID")+" / "+
                                "Task ID = " + rs.getString("taskID")+" / " +
                                "Task Type ID = "+rs.getString("task_detailID")+" / " +
                                "Status = " + rs.getString("status") +" / "+
                                "Department = " + rs.getString("department")+"\n"+
                                "Staff ID = " + rs.getString("StaffID")+" / "+
                                "Start Time =  "+rs.getTimestamp("startTime")+" / "+
                                "Completion Time = "+rs.getTimestamp("completionTime")+"\n"+"\n");

            }

        } catch (SQLException es) {
            es.printStackTrace();
        }
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskDisplay.setText("");
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM task Where jobID = "+SearchBar.getText());
                    while (rs.next() ) {
                        taskDisplay.append(
                                "Job ID = " + rs.getString("jobID")+" / "+
                                        "Task ID = " + rs.getString("taskID")+" / " +
                                        "Task Type ID = "+rs.getString("task_detailID")+" / " +
                                        "Status = " + rs.getString("status") +" / "+
                                        "Department = " + rs.getString("department")+"\n"+
                                        "Staff ID = " + rs.getString("StaffID")+" / "+
                                        "Start Time =  "+rs.getTimestamp("startTime")+" / "+
                                        "Completion Time = "+rs.getTimestamp("completionTime")+"\n"+"\n");


                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }


            }
        });
        completeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    String done = "Completed";
                    PreparedStatement jpst = connection.prepareStatement("UPDATE job SET amountcompleted = amountcompleted+1 WHERE jobID = ? AND amountcompleted!=taskamount");
                    PreparedStatement updateJobComp = connection.prepareStatement("UPDATE job SET completionDate=? WHERE jobID =? AND (amountcompleted=taskamount)");
                    PreparedStatement stopgap = connection.prepareStatement("SELECT jobID FROM task WHERE taskID=?");
                    stopgap.setInt(1,Integer.parseInt(TaskSearchField.getText()));
                    ResultSet stopgapset = stopgap.executeQuery();
                    while(stopgapset.next()){
                        jpst.setInt(1,stopgapset.getInt(1));
                        updateJobComp.setInt(2,stopgapset.getInt(1));
                        updateJobComp.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
                    }
                    jpst.executeUpdate();
                    updateJobComp.executeUpdate();
                    PreparedStatement pst = connection.prepareStatement("UPDATE task SET status= ?,StaffID =?,completionTime=? WHERE taskID = ?");
                    pst.setString(1,"Completed");
                    pst.setInt(2,Logged_in.getID());
                    pst.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
                    pst.setInt(4,Integer.parseInt(TaskSearchField.getText()));
                    pst.executeUpdate();
                    ResultSet rs = stmt.executeQuery("Select * from`task` Where taskID ="+TaskSearchField.getText());
                    while (rs.next() ) {
                        taskDisplay.setText("");
                        taskDisplay.append(
                                "Job ID = " + rs.getString("jobID")+" / "+
                                        "Task ID = " + rs.getString("taskID")+" / " +
                                        "Task Type ID = "+rs.getString("task_detailID")+" / " +
                                        "Status = " + rs.getString("status") +" / "+
                                        "Department = " + rs.getString("department")+"\n"+
                                        "Staff ID = " + rs.getString("StaffID")+" / "+
                                        "Start Time =  "+rs.getTimestamp("startTime")+" / "+
                                        "Completion Time = "+rs.getTimestamp("completionTime")+"\n"+"\n");

                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }
                TaskSearchField.setText("");
                JOptionPane.showMessageDialog(frame,"TASK COMPLETED");
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Technician technician = new Technician(Logged_in);
                technician.main();
                frame.dispose();
            }
        });
        beginTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {

                    String done = "Completed";
                    PreparedStatement pst = connection.prepareStatement("UPDATE task SET status= ?,StaffID =?, startTime=? WHERE taskID = ? AND status!='Completed'");
                    pst.setString(1,"In-Progress");
                    pst.setInt(2,Logged_in.getID());
                    pst.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
                    pst.setInt(4,Integer.parseInt(TaskSearchField.getText()));
                    pst.executeUpdate();
                    PreparedStatement stmt = connection.prepareStatement("Select * FROM task WHERE taskID =?");
                    stmt.setInt(1,Integer.parseInt(TaskSearchField.getText()));
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next() ) {
                        taskDisplay.setText("");
                        taskDisplay.append(
                                "Job ID = " + rs.getString("jobID")+" / "+
                                        "Task ID = " + rs.getString("taskID")+" / " +
                                        "Task Type ID = "+rs.getString("task_detailID")+" / " +
                                        "Status = " + rs.getString("status") +" / "+
                                        "Department = " + rs.getString("department")+"\n"+
                                        "Staff ID = " + rs.getString("StaffID")+" / "+
                                        "Start Time =  "+rs.getTimestamp("startTime")+" / "+
                                        "Completion Time = "+rs.getTimestamp("completionTime")+"\n"+"\n");

                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }
                TaskSearchField.setText("");
            }
        });
        filterIncompleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskDisplay.setText("");
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    PreparedStatement jobgap = connection.prepareStatement("SELECT jobID FROM job WHERE taskamount > amountcompleted");
                    ResultSet jobsfound = jobgap.executeQuery();
                    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM task WHERE jobID = ?");
                    while (jobsfound.next() ) {
                        stmt.setInt(1,jobsfound.getInt(1));
                        ResultSet rs = stmt.executeQuery();
                        while(rs.next()) {
                            taskDisplay.append(
                                    "Job ID = " + rs.getString("jobID") + " / " +
                                            "Task ID = " + rs.getString("taskID") + " / " +
                                            "Task Type ID = " + rs.getString("task_detailID") + " / " +
                                            "Status = " + rs.getString("status") + " / " +
                                            "Department = " + rs.getString("department") + "\n" +
                                            "Staff ID = " + rs.getString("StaffID") + " / " +
                                            "Start Time =  " + rs.getTimestamp("startTime") + " / " +
                                            "Completion Time = " + rs.getTimestamp("completionTime") + "\n" + "\n");

                        }
                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }
        });
        filterCompleteJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskDisplay.setText("");
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    PreparedStatement jobgap = connection.prepareStatement("SELECT jobID FROM job WHERE taskamount = amountcompleted");
                    ResultSet jobsfound = jobgap.executeQuery();
                    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM task WHERE jobID = ?");
                    while (jobsfound.next() ) {
                        stmt.setInt(1,jobsfound.getInt(1));
                        ResultSet rs = stmt.executeQuery();
                        while(rs.next()) {
                            taskDisplay.append(
                                    "Job ID = " + rs.getString("jobID") + " / " +
                                            "Task ID = " + rs.getString("taskID") + " / " +
                                            "Task Type ID = " + rs.getString("task_detailID") + " / " +
                                            "Status = " + rs.getString("status") + " / " +
                                            "Department = " + rs.getString("department") + "\n" +
                                            "Staff ID = " + rs.getString("StaffID") + " / " +
                                            "Start Time =  " + rs.getTimestamp("startTime") + " / " +
                                            "Completion Time = " + rs.getTimestamp("completionTime") + "\n" + "\n");

                        }
                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }
        });
        removeFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskDisplay.setText("");
                getConnector connector = new getConnector();
                try (Connection connection = connector.getConnection()) {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM task ");
                    while (rs.next() ) {
                        taskDisplay.append(
                                "Job ID = " + rs.getString("jobID")+" / "+
                                        "Task ID = " + rs.getString("taskID")+" / " +
                                        "Task Type ID = "+rs.getString("task_detailID")+" / " +
                                        "Status = " + rs.getString("status") +" / "+
                                        "Department = " + rs.getString("department")+"\n"+
                                        "Staff ID = " + rs.getString("StaffID")+" / "+
                                        "Start Time =  "+rs.getTimestamp("startTime")+" / "+
                                        "Completion Time = "+rs.getTimestamp("completionTime")+"\n"+"\n");

                    }

                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }
        });
    }

    public void main(){
        int width = 950;
        int height = 500;
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ViewTasks(getLoggedin()).ViewTasksPanel);
        frame.setVisible(true);
    }
}
