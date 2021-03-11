package com.arobs.internship.week1.lab8.ex4;

import java.util.Random;

public class FireSensor extends Sensor {
    private Random random;

    public FireSensor(String location, int id) {
        super(location, id, SensorType.FIRE);
        random = new Random();
    }

    @Override
    public int readValue() {
        return random.nextInt(100);
    }
}
