package org.example.studomat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddProfessorController {

    @FXML
    private Button btnAddProfessor;

    @FXML
    private Label lblError;

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
            Professor professor = new Professor(
                    tfName.getText(),
                    tfSurname.getText(),
                    tfOIB.getText(),
                    tfUsername.getText(),
                    tfPassword.getText()
            );
            professor.create();
            lblError.setText("Professor successfully added");
            tfName.clear();
            tfSurname.clear();
            tfOIB.clear();
            tfUsername.clear();
            tfPassword.clear();
        } catch (Exception e) {
            lblError.setText(e.getMessage());
        }


    }

}
