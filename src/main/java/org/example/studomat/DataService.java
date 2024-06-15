package org.example.studomat;

public class DataService {
    private static DataService instance = new DataService();
    private String userData;

    private DataService() {}

    public static DataService getInstance() {
        return instance;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }
}