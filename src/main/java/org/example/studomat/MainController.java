package org.example.studomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController implements IChangeScene {

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
    public void addCourse(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCourse.fxml"));
            AnchorPane subScene = loader.load();
            contentBox.getChildren().clear();
            contentBox.getChildren().add(subScene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void StudentList() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Students");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    @FXML
    public void ProfessorList() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProfessorList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Professors");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void CoursesList() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CourseList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800, 500);
        stage.setTitle("Courses");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void changeToScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
