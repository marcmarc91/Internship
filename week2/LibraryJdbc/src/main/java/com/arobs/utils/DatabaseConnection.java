package com.arobs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost/library";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    private DatabaseConnection() {
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connecting to DB...");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
