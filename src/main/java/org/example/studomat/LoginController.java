package org.example.studomat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

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
    public void handleLoginButtonAction() {
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        System.out.println(username);
        System.out.println(password);

        if (validateLogin(username, password)) {
            System.out.println("Login successful!");
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
            return resultSet.next();


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


}
}
