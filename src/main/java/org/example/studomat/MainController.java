package org.example.studomat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane contentBox;

    @FXML
    private Hyperlink hlAddCourse;

    @FXML
    private Hyperlink hlAddProfessor;

    @FXML
    private Hyperlink hlAddStudent;
    @FXML
    public void addStudent(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));
            AnchorPane subScene = loader.load();
            contentBox.getChildren().clear();
            contentBox.getChildren().add(subScene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void addProfessor(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProfessor.fxml"));
            AnchorPane subScene = loader.load();
            contentBox.getChildren().clear();
            contentBox.getChildren().add(subScene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void AddCourse(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCourse.fxml"));
            AnchorPane subScene = loader.load();
            contentBox.getChildren().clear();
            contentBox.getChildren().add(subScene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
