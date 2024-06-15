package org.example.studomat;

public class Professor extends Person{
    public Professor(String name, String surname, String OIB, String username, String password) throws Exception {
        super(name, surname, OIB, username, password);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
}
