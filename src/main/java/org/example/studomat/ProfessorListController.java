package org.example.studomat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ProfessorListController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnExport;

    @FXML
    private Button btnUpdate;

    @FXML
    private Label lblError;

    @FXML
    private Label lblId;

    @FXML
    private ListView<Professor> listView;

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
    public void initialize() {
        Professor professor  = new Professor();
        listView.setItems(professor.all());
    }

    public void selectedProfessor(){
        lblError.setText("");
        Professor selectedProfessor = listView.getSelectionModel().getSelectedItem();
        lblId.setText(String.valueOf(selectedProfessor.getId()));
        tfName.setText(selectedProfessor.getName());
        tfSurname.setText(selectedProfessor.getSurname());
        tfOIB.setText(selectedProfessor.getOIB());
        tfUsername.setText(selectedProfessor.getUsername());
        tfPassword.setText(selectedProfessor.getPassword());
    }
    public void updateProfessor() throws Exception {
        int id = Integer.parseInt(lblId.getText());
        String name = tfName.getText();
        String surname = tfSurname.getText();
        String OIB = tfOIB.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        try {
            Professor professor = new Professor(id, name, surname, OIB, username, password);
            professor.update();
            lblError.setText("The professor has been updated successfully");
            initialize();
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }
    private void clearForm(){
        lblId.setText("");
        tfName.clear();
        tfSurname.clear();
        tfOIB.clear();
        tfUsername.clear();
        tfPassword.clear();
    }
    public void deleteProfessor() throws Exception {
        int id = Integer.parseInt(lblId.getText());
        String name = tfName.getText();
        String surname = tfSurname.getText();
        String OIB = tfOIB.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        try {
            Professor professor = new Professor(id,name,surname,OIB,username,password);
            professor.delete();
            lblError.setText("The student has been deleted successfully");
            initialize();
            clearForm();
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }
    public void exportData() {
        try {
            Professor professor = new Professor();
            String filePath = "professors.json";
            professor.serializeToJson(professor.all(), filePath);
            lblError.setText("Data successfully exported");
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }

}
