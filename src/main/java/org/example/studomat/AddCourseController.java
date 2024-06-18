package org.example.studomat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddCourseController {

    @FXML
    private Button btnAddCourse;

    @FXML
    private ComboBox<Integer> comBoxECTS;

    @FXML
    private ComboBox<Integer> comBoxGrade;

    @FXML
    private ComboBox<Professor> comBoxProfessor;

    @FXML
    private ComboBox<Integer> comBoxSemester;

    @FXML
    private Label lblError;

    @FXML
    private TextArea tfDescription;

    @FXML
    private TextField tfName;

    @FXML
    public void initialize() {
        comBoxGrade.setItems(Grades());
        comBoxECTS.setItems(ECTS());
        comBoxSemester.setItems(Semester());
        comBoxProfessor.setItems(Professor());

    }
    private ObservableList<Integer> Grades(){
        ObservableList<Integer> grades = FXCollections.observableArrayList();
        grades.addAll(0,1, 2, 3,4,5);
        return grades;

    }
    private ObservableList<Integer> ECTS(){
        ObservableList<Integer> ECTS = FXCollections.observableArrayList();
        ECTS.addAll(1, 2, 3,4,5,6,7,8,9,10);
        return ECTS;

    }
    private ObservableList<Integer> Semester(){
        ObservableList<Integer> semester = FXCollections.observableArrayList();
        semester.addAll(1, 2, 3,4,5,6);
        return semester;
    }
    public ObservableList<Professor> Professor() {
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
    @FXML
    public void checkForm(){
        String name = tfName.getText();
        String description = tfDescription.getText();
        int semester = comBoxSemester.getValue();
        int ECTS = comBoxECTS.getValue();
        int grade = comBoxGrade.getValue();
        int idProfessor = comBoxProfessor.getValue().getId();
        System.out.println(name+" "+description+" "+semester+" "+ECTS+" "+grade+" "+idProfessor);

        try {
            Course course = new Course(
                    name,
                    description,
                    semester,
                    ECTS,
                    grade,
                    idProfessor
            );
            course.create();
            lblError.setText("Course was inserted successfully!");
            tfDescription.clear();
            tfName.clear();
            comBoxSemester.setValue(null);
            comBoxECTS.setValue(null);
            comBoxGrade.setValue(null);
            comBoxProfessor.setValue(null);
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }


    }
}
