package com.example.lesson4android1.model;

import java.io.Serializable;

public class BooksModel implements Serializable {
    private String name;
    private String description;


    public BooksModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
