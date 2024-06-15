package org.example.studomat;

public class DataService {
    private static DataService instance = new DataService();
    private int userData;

    private DataService() {}

    public static DataService getInstance() {
        return instance;
    }

    public int getUserData() {
        return userData;
    }

    public void setUserData(int userData) {
        this.userData = userData;
    }
}