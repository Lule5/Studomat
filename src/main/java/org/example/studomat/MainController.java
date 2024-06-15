package org.example.studomat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ListView<Pane> coursesListView;

    public void initialize() {
        List<Course> courses = fetchCoursesFromDatabase();

        for (Course course : courses) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("courseItem.fxml"));
                Pane listItem = loader.load();

                CourseItemController controller = loader.getController();
                controller.setCourseData(course);

                coursesListView.getItems().add(listItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Course> fetchCoursesFromDatabase() {
        String query = "SELECT * FROM courses";
        List<Course> courses = new ArrayList<>();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String description = resultSet.getString("Description");
                int semester = resultSet.getInt("Semester");
                int ects = resultSet.getInt("ECTS");
                int grade = resultSet.getInt("Grade");
                int idProfessor = resultSet.getInt("IdProfessor");

                Course course = new Course(name, description, semester, ects, grade, idProfessor);
                courses.add(course);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courses;
    }
}