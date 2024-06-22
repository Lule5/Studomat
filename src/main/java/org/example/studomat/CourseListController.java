package org.example.studomat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CourseListController {
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnExport;

    @FXML
    private Button btnUpdate;
    @FXML
    private ListView<Course> listView;
    @FXML
    private ComboBox<Integer> comBoxECTS;

    @FXML
    private ComboBox<Integer> comBoxFilter;

    @FXML
    private ComboBox<Integer> comBoxGrade;

    @FXML
    private ComboBox<Professor> comBoxProfessor;

    @FXML
    private ComboBox<Integer> comBoxSemester;

    @FXML
    private Label lblError;

    @FXML
    private Label lblId;

    @FXML
    private TextArea tfDescription;

    @FXML
    private TextField tfName;
    private ObservableList<Course> allCourses;
    public void initialize() {
        AddCourseController courseController = new AddCourseController();
        Professor professor = new Professor();
        Course course = new Course();
        comBoxGrade.setItems(courseController.Grades());
        comBoxECTS.setItems(courseController.ECTS());
        comBoxSemester.setItems(courseController.Semester());
        comBoxProfessor.setItems(professor.all());
        allCourses = course.all();
        listView.setItems(allCourses);
        comBoxFilter.setItems(courseController.Semester());
    }
    public void selectedCourse(){
        lblError.setText("");
        Course selectedCourse = listView.getSelectionModel().getSelectedItem();
        lblId.setText(String.valueOf(selectedCourse.getId()));
        tfName.setText(selectedCourse.getName());
        tfDescription.setText(selectedCourse.getDescription());
        comBoxSemester.setValue(selectedCourse.getSemester());
        comBoxECTS.setValue(selectedCourse.getECTS());
        comBoxGrade.setValue(selectedCourse.getGrade());
        comBoxProfessor.setValue(selectedCourse.getProfessorById());
    }

    public void updateCourse() throws Exception {
        int id = Integer.parseInt(lblId.getText());
        String name = tfName.getText();
        String description = tfDescription.getText();
        int semester = comBoxSemester.getValue();
        int ECTS = comBoxECTS.getValue();
        int grade = comBoxGrade.getValue();
        int idProfessor = comBoxProfessor.getValue().getId();

        try {
            Course course = new Course(id,name,description,semester,ECTS,grade,idProfessor);
            course.update();
            lblError.setText("The course has been updated successfully");
            initialize();
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }
    private void clearForm(){
        lblId.setText("");
        tfName.clear();
        tfDescription.clear();
        comBoxSemester.setValue(null);
        comBoxECTS.setValue(null);
        comBoxGrade.setValue(null);
        comBoxProfessor.setValue(null);
    }
    public void deleteCourse() throws Exception {
        int id = Integer.parseInt(lblId.getText());
        String name = tfName.getText();
        String description = tfDescription.getText();
        int semester = comBoxSemester.getValue();
        int ECTS = comBoxECTS.getValue();
        int grade = comBoxGrade.getValue();
        int idProfessor = comBoxProfessor.getValue().getId();
        try {
            Course course = new Course(id,name,description,semester,ECTS,grade,idProfessor);
            course.delete();
            lblError.setText("The student has been deleted successfully");
            initialize();
            clearForm();
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }
    public void exportData() {
        try {
            Course course = new Course();
            String filePath = "courses.json";
            course.serializeToJson(listView.getItems(), filePath);
            lblError.setText("Data successfully exported");
        }catch (Exception e){
            lblError.setText(e.getMessage());
        }
    }
    public void filterCoursesBySemester() {
        Integer selectedSemester = comBoxFilter.getValue();
        if (selectedSemester != null) {
            ObservableList<Course> filteredCourses = allCourses.filtered(course -> course.getSemester() == selectedSemester);
            if (!filteredCourses.isEmpty()) {
                listView.setItems(filteredCourses);
                lblError.setText("");
            } else {
                listView.setItems(filteredCourses);
                lblError.setText("No courses available for the selected semester.");
            }
        } else{
            listView.setItems(allCourses);
            lblError.setText("");
        }

    }

}
