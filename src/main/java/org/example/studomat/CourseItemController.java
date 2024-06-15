package org.example.studomat;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CourseItemController {

    @FXML
    private Label lblCourse;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblECTS;

    @FXML
    private Label lblGrade;

    @FXML
    private Label lblProfessor;

    @FXML
    private Label lblSemester;
    public void setCourseData(Course course) {
        lblCourse.setText(course.getName());
        lblDescription.setText(course.getDescription());
        lblSemester.setText(String.valueOf(course.getSemester()));
        lblECTS.setText(String.valueOf(course.getECTS()));
        lblProfessor.setText(course.getProfessor(course.getIdProfessor()).getName() + " " + course.getProfessor(course.getIdProfessor()).getSurname());
        lblGrade.setText(String.valueOf(course.getGrade()));
    }
}
