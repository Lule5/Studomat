package org.example.studomat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student extends Person implements ICrud<Student> {
    public Student(){}
    public Student(String name, String surname, String OIB,String JMBAG, String username, String password) throws Exception {
        super(name, surname, OIB, username, password);
        setJMBAG(JMBAG);
    }
    public Student(int id,String name, String surname, String OIB,String JMBAG, String username, String password) throws Exception {
        super(name, surname, OIB, username, password);
        setJMBAG(JMBAG);
        setId(id);
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) throws Exception {
        if(JMBAG.length()==10 && JMBAG.matches("[0-9]+")) {
            this.JMBAG = JMBAG;
        }else{
            throw new Exception("Invalid JMBAG");
        }
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public void create() {


        String query = "INSERT INTO students (name, surname,OIB,JMBAG, username, password) VALUES (?,?,?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getSurname());
            preparedStatement.setString(3, this.getOIB());
            preparedStatement.setString(4, this.getJMBAG());
            preparedStatement.setString(5, this.getUsername());
            preparedStatement.setString(6, this.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting student into database", e);
        }

    }

    @Override
    public  ObservableList<Student> all() {
        ObservableList<Student> students = FXCollections.observableArrayList();

        String query = "SELECT * FROM students";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id =resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String OIB = resultSet.getString("OIB");
                String JMBAG = resultSet.getString("JMBAG");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");
                students.add(new Student(id,name, surname,OIB,JMBAG,username,password));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return students;

    }

    @Override
    public String toString() {
        return this.getName()+" " +this.getSurname()+" "+this.getOIB();
    }

    private String JMBAG;
    private int Id;


}
