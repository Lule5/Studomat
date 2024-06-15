package org.example.studomat;

public abstract class Person {
    public Person(String name, String surname, String OIB, String username, String password) throws Exception {
        this.name = name;
        this.surname = surname;
        setOIB(OIB);
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) throws Exception {
        if(OIB.length()==11 && OIB.matches("[0-9]+")) {
            this.OIB = OIB;
        }else{
            throw new Exception("Invalid OIB");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name;
    private String surname;
    private String OIB;
    private String username;
    private String password;
}
