package org.shehan.dao;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;


public class DBconnection {


    private static final String URL = "jdbc:postgresql://localhost:5432/inventory";
    private static final String USER = "postgres";
    private static final String PASSWORD = "post123";
    private static DBconnection instance;

    public DBconnection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL Driver not found", e);
        }
    }

    public static synchronized DBconnection getInstance() {
        if (instance == null)
            instance = new DBconnection();
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}
