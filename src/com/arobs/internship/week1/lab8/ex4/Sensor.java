package com.arobs.internship.week1.lab8.ex4;

public abstract class Sensor {
    private String location;
    private int id;
    private SensorType sensorType;

    public Sensor(String location, int id, SensorType sensorType) {
        this.location = location;
        this.id = id;
        this.sensorType = sensorType;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public abstract int readValue();
}
