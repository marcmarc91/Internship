package com.arobs.internship.week1.lab8.ex4.test;

import com.arobs.internship.week1.lab8.ex4.*;

public class HomeAutomation {

    public static void main(String[] args) {
        //test using an annonimous inner class
//        Home h = new Home() {
//            protected void setValueInEnvironment(Event event) {
//                System.out.println("New event in environment " + event);
//            }
//
//            protected void controllStep() {
//                System.out.println("Control step executed");
//            }
//        };
//        h.simulate();

        ControlUnit controlUnit = ControlUnit.getInstance();
        controlUnit.setTemperatureSensor(new TemperatureSensor("Living", 2));
        controlUnit.addFireSonsor(new FireSensor("Kitchen", 25));
        controlUnit.addFireSonsor(new FireSensor("Bedroom", 35));
        controlUnit.addFireSonsor(new FireSensor("Garage", 81));
        controlUnit.setCoolingUnit(new CoolingUnit());
        controlUnit.setGsmUnit(new GsmUnit());
        controlUnit.setHeatingUnit(new HeatingUnit());
        controlUnit.setAlarmUnit(new AlarmUnit());
        controlUnit.setMyTemp(25);

        controlUnit.start();

    }
}