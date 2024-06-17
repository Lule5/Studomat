package org.example.studomat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddStudentController {

    @FXML
    private Button btnAdd;

    @FXML
    private Label lblError;

    @FXML
    private TextField tfJMBAG;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfOIB;

    @FXML
    private PasswordField tfPassword;

    @FXML
    private TextField tfSurname;

    @FXML
    private TextField tfUsername;

    @FXML
    public void checkForm(){
        try {
            Student student = new Student(
                    tfName.getText(),
                    tfSurname.getText(),
                    tfOIB.getText(),
                    tfJMBAG.getText(),
                    tfUsername.getText(),
                    tfPassword.getText()
            );
            student.create();
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }
        lblError.setText("Student successfully added");
        tfName.clear();
        tfSurname.clear();
        tfOIB.clear();
        tfJMBAG.clear();
        tfUsername.clear();
        tfPassword.clear();

    }

}
