package com.arobs.internship.week1.lab5.ex3;

public abstract class Sensor {
    private String location;

    public Sensor(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public abstract int readValue();

}
