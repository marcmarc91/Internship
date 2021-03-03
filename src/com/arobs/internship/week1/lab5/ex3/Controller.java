package com.arobs.internship.week1.lab5.ex3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Controller {
    LightSensor lightSensor;
    TemperatureSensor temperatureSensor;

    public void control() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.printf("Light sensor value: %s from %s.%n",
                        lightSensor.readValue(),
                        lightSensor.getLocation());
                System.out.printf("Temperature sensor value: %s from %s.%n",
                        temperatureSensor.readValue(),
                        temperatureSensor.getLocation());
            }
        }, 0, TimeUnit.SECONDS.toMillis(1));
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    public void setLightSensor(LightSensor lightSensor) {
        this.lightSensor = lightSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

}
