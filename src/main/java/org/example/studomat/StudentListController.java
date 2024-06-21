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
    private Button btnExport;

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
    private TextField tfPassword;

    @FXML
    private TextField tfSurname;

    @FXML
    private TextField tfUsername;

    @FXML
    public void initialize() {
        Student student = new Student();
        listView.setItems(student.all());
    }

    public void selectedStudent(){
        Student selectedStudent = listView.getSelectionModel().getSelectedItem();
        lblId.setText(String.valueOf(selectedStudent.getId()));
        tfName.setText(selectedStudent.getName());
        tfSurname.setText(selectedStudent.getSurname());
        tfOIB.setText(selectedStudent.getOIB());
        tfJMBAG.setText(selectedStudent.getJMBAG());
        tfUsername.setText(selectedStudent.getUsername());
        tfPassword.setText(selectedStudent.getPassword());
    }
    public void updateStudent() throws Exception {
        int id = Integer.parseInt(lblId.getText());
        String name = tfName.getText();
        String surname = tfSurname.getText();
        String OIB = tfOIB.getText();
        String JMBAG = tfJMBAG.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        try {
            Student student = new Student(id,name,surname,OIB,JMBAG,username,password);
            student.update();
            lblError.setText("The student has been updated successfully");
            initialize();
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }
    public void deleteStudent() throws Exception {
        int id = Integer.parseInt(lblId.getText());
        String name = tfName.getText();
        String surname = tfSurname.getText();
        String OIB = tfOIB.getText();
        String JMBAG = tfJMBAG.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        try {
            Student student = new Student(id,name,surname,OIB,JMBAG,username,password);
            student.delete();
            lblError.setText("The student has been deleted successfully");
            initialize();
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }
    public void exportData(){
        Student student = new Student();
        String filePath = "students.json";
        student.serializeToJson(student.all(), filePath);
    }

}
