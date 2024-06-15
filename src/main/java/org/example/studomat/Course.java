package org.example.studomat;

public class Course {
    public Course(String name, String description, int semester, int ECTS, int grade, int idProfessor) {
        this.name = name;
        this.description = description;
        this.semester = semester;
        this.ECTS = ECTS;
        this.grade = grade;
        this.idProfessor = idProfessor;
    }
    public Course(String name, String description, int semester, int ECTS, int idProfessor) {
        this.name = name;
        this.description = description;
        this.semester = semester;
        this.ECTS = ECTS;
        this.grade = null;
        this.idProfessor = idProfessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    private String name;
    private String description;
    private int semester;
    private int ECTS;
    private Integer grade;
    private int idProfessor;
}
