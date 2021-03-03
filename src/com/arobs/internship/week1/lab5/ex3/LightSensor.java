package com.arobs.internship.week1.lab5.ex3;

import java.util.Random;

public class LightSensor extends Sensor {
    Random random;

    public LightSensor(String location) {
        super(location);
        random = new Random();
    }

    @Override
    public int readValue() {
        return random.nextInt(100);
    }
}
