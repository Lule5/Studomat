package org.example.studomat;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static DBConnection instance=null;
    private Connection databaseLink;

    private DBConnection() {
        try {
            String databaseName = "studomat";
            String databaseUser = "llucic";
            String databasePassword = "koliko88";
            String url = "jdbc:mysql://localhost:3306/" + databaseName;

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    public Connection getConnection() {
        return databaseLink;
    }
}