package org.example.studomat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class StudentListController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label lblError;

    @FXML
    private Label lblId;

    @FXML
    private ListView<Student> listView;

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

}
