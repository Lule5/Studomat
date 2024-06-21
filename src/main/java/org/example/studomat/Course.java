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

public class Course implements ICrud<Course> {
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

    @Override
    public ObservableList<Course> all() {
        ObservableList<Course> courses = FXCollections.observableArrayList();

        String query = "SELECT * FROM courses";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id =resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String description = resultSet.getString("Description");
                int semester = resultSet.getInt("Semester");
                int ECTS = resultSet.getInt("ECTS");
                int grade = resultSet.getInt("Grade");
                int idProfessor = resultSet.getInt("IdProfessor");
                courses.add(new Course(id,name,description,semester,ECTS,grade,idProfessor));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return courses;
    }

    @Override
    public void update() {
        String query = "UPDATE courses SET name=?, description=?, semester=?, ECTS=?, grade=?, IdProfessor=? WHERE id=?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, this.getName());
            preparedStatement.setString(2, this.getDescription());
            preparedStatement.setInt(3, this.getSemester());
            preparedStatement.setInt(4, this.getECTS());
            preparedStatement.setInt(5, this.getGrade());
            preparedStatement.setInt(6, this.getIdProfessor());
            preparedStatement.setInt(7, this.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating course in database", e);
        }
    }

    @Override
    public void delete() {
        String query = "DELETE FROM courses WHERE id=?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, this.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting course from database", e);
        }
    }
    public void serializeToJson(ObservableList<Course> courses, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), courses);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing csourses to JSON", e);
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
