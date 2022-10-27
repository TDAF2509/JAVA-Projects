package com.TDAF;
import java.sql.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;

public class GetConnector {

    private static final String URL = "jdbc:mysql://localhost/bapers";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public Connection GetConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", USERNAME);
        connectionProps.put("password", PASSWORD);


        Connection connection = DriverManager.getConnection(URL, connectionProps);
        System.out.println("Connected to BAPERS Database.");
        return connection;
    }
}
