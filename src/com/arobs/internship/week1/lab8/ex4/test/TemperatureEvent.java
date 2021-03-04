package com.arobs.internship.week1.lab8.ex4.test;

public class TemperatureEvent extends Event {

    private int vlaue;

    public TemperatureEvent(int vlaue) {
        super(EventType.TEMPERATURE);
        this.vlaue = vlaue;
    }

    int getVlaue() {
        return vlaue;
    }

    @Override
    public String toString() {
        return "TemperatureEvent{" + "vlaue=" + vlaue + '}';
    }

}