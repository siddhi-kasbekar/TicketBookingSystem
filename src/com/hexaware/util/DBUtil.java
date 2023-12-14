package com.hexaware.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ticketbooking";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sid@2002";

    // Prevent instantiation
    private DBUtil() {
    }

    public static Connection getDBConn() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database driver not found", e);
        }
    }
}
