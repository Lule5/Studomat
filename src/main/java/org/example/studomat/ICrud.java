package org.example.studomat;

import javafx.collections.ObservableList;

public interface ICrud<T> {
    public void create();
    public  ObservableList<T> all();
}
