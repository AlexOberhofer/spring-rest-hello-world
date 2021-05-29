package com.amo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection _connection;

    public static Connection getConnection() {

        if(_connection == null) {
            try {
                _connection = DriverManager.getConnection("jdbc:mysql://localhost/sample",
                        "root", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return _connection;
    }

    public static Connection close() {
        if(_connection != null) {
            try {
                _connection.close();
                _connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
