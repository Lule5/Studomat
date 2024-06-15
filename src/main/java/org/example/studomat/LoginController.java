package org.example.studomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController implements IChangeScene{

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView imgLogo;

    @FXML
    private Label lblError;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfUsername;
    @FXML
    public void handleLoginButtonAction(ActionEvent event) {
        String username = tfUsername.getText();
        String password = tfPassword.getText();

        if (validateLogin(username, password)) {
            changeToScene(event);
        } else {
            tfUsername.clear();
            tfPassword.clear();
            lblError.setText("Invalid username or password!");
        }
    }

    private boolean validateLogin(String username, String password) {
        String query = "SELECT * FROM students WHERE username = ? AND password = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
             if(resultSet.next()) {
                 DataService.getInstance().setUserData(resultSet.getInt("ID"));
                 return true;
             }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public void changeToScene(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 786, 671);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Studomat");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();}

}

