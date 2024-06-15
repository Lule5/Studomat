package org.example.studomat;

public class Student extends Person {
    public Student(String name, String surname, String OIB,String JMBAG, String username, String password) throws Exception {
        super(name, surname, OIB, username, password);
        setJMBAG(JMBAG);
    }

    public String getJMBAG() {
        return JMBAG;
    }

    public void setJMBAG(String JMBAG) throws Exception {
        if(JMBAG.length()==10 && JMBAG.matches("[0-9]+")) {
            this.JMBAG = JMBAG;
        }else{
            throw new Exception("Invalid JMBAG");
        }
    }

    private String JMBAG;


}
