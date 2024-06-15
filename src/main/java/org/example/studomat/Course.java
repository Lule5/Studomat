package org.example.studomat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    public Course(String name, String description, int semester, int ECTS, int grade, int idProfessor) {
        this.name = name;
        this.description = description;
        this.semester = semester;
        this.ECTS = ECTS;
        this.grade = grade;
        this.idProfessor = idProfessor;
    }
    public Course(String name, String description, int semester, int ECTS, int idProfessor) {
        this.name = name;
        this.description = description;
        this.semester = semester;
        this.ECTS = ECTS;
        this.grade = null;
        this.idProfessor = idProfessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
    public Professor getProfessor(int id){
        String query = "SELECT * FROM professors WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String OIB = resultSet.getString("OIB");
                String username = resultSet.getString("Username");
                String password = resultSet.getString("Password");

                return new Professor(name, surname, OIB,username,password);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private String name;
    private String description;
    private int semester;
    private int ECTS;
    private Integer grade;
    private int idProfessor;
}
