package com.TDAF;
import java.sql.*;
import java.util.Properties;

public class getConnector {
    private static final String URL = "jdbc:mysql://localhost/bapers";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", USERNAME);
        connectionProps.put("password", PASSWORD);

        Connection connection = DriverManager.getConnection(URL, connectionProps);
        System.out.println("Connected to BAPERS Database.");
        return connection;
    }

}
