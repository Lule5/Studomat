package org.example.studomat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student extends Person implements ICrud {
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


    private String JMBAG;
    private int Id;


}
