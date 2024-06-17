package org.example.studomat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Professor extends Person implements ICrud{
    public Professor(String name, String surname, String OIB, String username, String password) throws Exception {
        super(name, surname, OIB, username, password);
    }
    @Override
    public void create() {


        String query = "INSERT INTO professors (name, surname,OIB, username, password) VALUES (?,?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getSurname());
            preparedStatement.setString(3, this.getOIB());
            preparedStatement.setString(4, this.getUsername());
            preparedStatement.setString(5, this.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting professor into database", e);
        }

    }


}
