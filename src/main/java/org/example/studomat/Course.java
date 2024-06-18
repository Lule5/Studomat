package org.example.studomat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Course implements ICrud {
    public Course(String name, String description, int semester, int ECTS, int grade, int idProfessor) throws Exception {
        setName(name);
        setDescription(description);
        setSemester(semester);
        setECTS(ECTS);
        setGrade(grade);
        setIdProfessor(idProfessor);

    }
    public Course(int id,String name, String description, int semester, int ECTS, int grade, int idProfessor) throws Exception {
        setId(id);
        setName(name);
        setDescription(description);
        setSemester(semester);
        setECTS(ECTS);
        setGrade(grade);
        setIdProfessor(idProfessor);

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name == null || name.trim().isEmpty()){
            throw new Exception("Name is required!");
        }
        if(name.length()>35) {
            throw new Exception("Name is too long (max 35)");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws Exception {
        if(description.length()>70) {
            throw new Exception("description is too long (max 70)");
        }
        this.description = description;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) throws Exception {
        if(semester>0 && semester<=6) {
            this.semester = semester;
        }else{
            throw new Exception("Invalid semester");
        }

    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade >= 0 && grade <= 5) {
            this.grade = grade;
        }
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
    @Override
    public void create() {
        String query = "INSERT INTO courses (name, description, semester, ECTS, grade, IdProfessor) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getDescription());
            preparedStatement.setInt(3, this.getSemester());
            preparedStatement.setInt(4, this.getECTS());
            preparedStatement.setInt(5, this.getGrade());
            preparedStatement.setInt(6, this.getIdProfessor());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            throw new RuntimeException("Error inserting course into database", e);
        }

    }
    private int Id;
    private String name;
    private String description;
    private int semester;
    private int ECTS;
    private int grade;
    private int idProfessor;


}
