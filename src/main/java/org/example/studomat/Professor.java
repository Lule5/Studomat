package org.example.studomat;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor extends Person implements ICrud<Professor>{
    public Professor(){}
    public Professor(String name, String surname, String OIB, String username, String password) throws Exception {
        super(name, surname, OIB, username, password);
    }
    public Professor(int id,String name, String surname, String OIB, String username, String password) throws Exception {
        super(name, surname, OIB, username, password);
        setId(id);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    @Override
    public ObservableList<Professor> all() {
        ObservableList<Professor> professors = FXCollections.observableArrayList();

        String query = "SELECT * FROM professors";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id =resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String OIB = resultSet.getString("OIB");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                professors.add(new Professor(id,name, surname,OIB,username,password));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return professors;
    }

    @Override
    public void update() {
        String query = "UPDATE professors SET name=?, surname=?, OIB=?, username=?, password=? WHERE id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getSurname());
            preparedStatement.setString(3, this.getOIB());
            preparedStatement.setString(4, this.getUsername());
            preparedStatement.setString(5, this.getPassword());
            preparedStatement.setInt(6, this.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating professor in database", e);
        }
    }

    @Override
    public void delete() {
        String query = "DELETE FROM professors WHERE id=?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, this.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting professor from database", e);
        }
    }
    public void serializeToJson(ObservableList<Professor> professors, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), professors);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing professors to JSON", e);
        }
    }


    @Override
    public String toString(){

        return getName() + " " + getSurname();
    }
    private int Id;


}
