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
        Professor professor = new Professor();
        comBoxGrade.setItems(Grades());
        comBoxECTS.setItems(ECTS());
        comBoxSemester.setItems(Semester());
        comBoxProfessor.setItems(professor.all());

    }
    public ObservableList<Integer> Grades(){
        ObservableList<Integer> grades = FXCollections.observableArrayList();
        grades.addAll(0,1, 2, 3,4,5);
        return grades;

    }
    public ObservableList<Integer> ECTS(){
        ObservableList<Integer> ECTS = FXCollections.observableArrayList();
        ECTS.addAll(1, 2, 3,4,5,6,7,8,9,10);
        return ECTS;

    }
    public ObservableList<Integer> Semester(){
        ObservableList<Integer> semester = FXCollections.observableArrayList();
        semester.addAll(1, 2, 3,4,5,6);
        return semester;
    }

    @FXML
    public void checkForm(){
        String name = tfName.getText();
        String description = tfDescription.getText();
        int semester = comBoxSemester.getValue();
        int ECTS = comBoxECTS.getValue();
        int grade = comBoxGrade.getValue();
        int idProfessor = comBoxProfessor.getValue().getId();

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
