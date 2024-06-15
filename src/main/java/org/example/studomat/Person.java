package org.example.studomat;

abstract class Person {
    public Person(String name, String surname, String OIB) {
        this.name = name;
        this.surname = surname;
        this.OIB = OIB;
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

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    private String name;
    private String surname;
    private String OIB;
}
