package com.arobs.internship.week1.lab8.ex4;

import java.util.List;
import java.util.Random;

public class TemperatureSensor extends Sensor {
    Random random;

    public TemperatureSensor(String location, int id) {
        super(location, id, SensorType.TEMPERATURE);
        random = new Random();
    }

    @Override
    public int readValue() {
        return random.nextInt(100);
    }
}
