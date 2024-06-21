package org.example.studomat;

public abstract class Person {
    public Person(){}
    public Person(String name, String surname, String OIB, String username, String password) throws Exception {
        setName(name);
        setSurname(surname);
        setOIB(OIB);
        setUsername(username);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name == null || name.trim().isEmpty()){
            throw new Exception("Name is required!");
        }
        if(name.length()>20) {
            throw new Exception("Name is too long (max 20)");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws Exception {
        if(surname == null || surname.trim().isEmpty()){
            throw new Exception("Surname is required!");
        }
        if(surname.length()>20) {
            throw new Exception("Surname is too long (max 20)");
        }
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

    public void setUsername(String username) throws Exception {
        if(username == null || username.trim().isEmpty()){
            throw new Exception("Username is required!");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if(password == null || password.trim().isEmpty()){
            throw new Exception("Password is required!");
        }
        this.password = password;
    }

    private String name;
    private String surname;
    private String OIB;
    private String username;
    private String password;
}
