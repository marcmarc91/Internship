package com.arobs.internship.week1.lab8.ex4;

import com.arobs.internship.week1.lab8.ex4.test.TemperatureEvent;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit implements Unit {
    private static ControlUnit instance;
    private final int SIMULATION_STEPS = 5;

    private TemperatureSensor temperatureSensor;
    private final List<FireSensor> fireSensorList;
    private AlarmUnit alarmUnit;
    private CoolingUnit coolingUnit;
    private GsmUnit gsmUnit;
    private HeatingUnit heatingUnit;
    private boolean power;
    private int myTemp;

    private ControlUnit() {
        fireSensorList = new ArrayList<>();
        myTemp = 25;
        power = true;
    }

    public static ControlUnit getInstance() {
        if (instance == null) {
            return new ControlUnit();
        } else {
            return instance;
        }
    }

    @Override
    public void start() {
        System.out.println("Control unit has been started!");
        int count = 0;
        while (power) {
            int valueTemp = temperatureSensor.readValue();
            System.out.printf("Temperature sensor value: %s from %s (set value:%s)%n",
                    valueTemp, temperatureSensor.getLocation(), myTemp);
            if (valueTemp > 25) {
                coolingUnit.start();
                new TemperatureEvent(valueTemp);
            } else {
                heatingUnit.start();
            }
            for (FireSensor fireSensor : fireSensorList) {
                int valueFire = fireSensor.readValue();
                System.out.printf("Fire sensor value: %s from %s (max value:%s)%n",
                        valueFire, fireSensor.getLocation(), 50);
                if (valueFire > 50) {
                    alarmUnit.start();
                    gsmUnit.start();
                } else {
                    alarmUnit.stop();
                }
            }
            System.out.println("--------------------" + System.lineSeparator());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (count > SIMULATION_STEPS) {
                stop();
            }
        }
    }

    @Override
    public void stop() {
        power = false;
        System.out.println("Control unit has been stopped!");
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public List<FireSensor> getFireSensorList() {
        return fireSensorList;
    }

    public void addFireSonsor(FireSensor fireSensor) {
        fireSensorList.add(fireSensor);
    }

    public AlarmUnit getAlarmUnit() {
        return alarmUnit;
    }

    public void setAlarmUnit(AlarmUnit alarmUnit) {
        this.alarmUnit = alarmUnit;
    }

    public CoolingUnit getCoolingUnit() {
        return coolingUnit;
    }

    public void setCoolingUnit(CoolingUnit coolingUnit) {
        this.coolingUnit = coolingUnit;
    }

    public GsmUnit getGsmUnit() {
        return gsmUnit;
    }

    public void setGsmUnit(GsmUnit gsmUnit) {
        this.gsmUnit = gsmUnit;
    }

    public HeatingUnit getHeatingUnit() {
        return heatingUnit;
    }

    public void setHeatingUnit(HeatingUnit heatingUnit) {
        this.heatingUnit = heatingUnit;
    }

    public int getMyTemp() {
        return myTemp;
    }

    public void setMyTemp(int myTemp) {
        this.myTemp = myTemp;
    }
}
