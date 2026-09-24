package com.saucedemo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/saucedemo_test";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            System.getenv("SAUCEDEMO_DB_PASSWORD");

    public static Connection getConnection()
            throws SQLException {

        if (PASSWORD == null || PASSWORD.isBlank()) {

            throw new SQLException(
                    "Environment variable SAUCEDEMO_DB_PASSWORD is not set."
            );
        }

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    public static void main(String[] args) {

        try {

            Connection connection =
                    getConnection();

            System.out.println(
                    "MySQL connection successful!"
            );

            connection.close();

        } catch (SQLException e) {

            System.out.println(
                    "MySQL connection failed!"
            );

            e.printStackTrace();
        }
    }
}