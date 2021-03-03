package com.arobs.internship.week1.lab6.ex4;

public class Definition {
    private String description;

    public Definition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "description= " + description;
    }
}
