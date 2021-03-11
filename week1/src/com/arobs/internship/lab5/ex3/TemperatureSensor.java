package com.arobs.internship.week1.lab5.ex3;

import java.util.Random;

public class TemperatureSensor extends Sensor {
    private Random random;

    public TemperatureSensor(String location) {
        super(location);
        random = new Random();
    }

    @Override
    public int readValue() {
        return random.nextInt(100);
    }
}
