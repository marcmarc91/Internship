package com.arobs.internship.week1.lab8.ex4;

public class HeatingUnit implements Unit {
    @Override
    public void start() {
        System.out.println("*The heating unit has been power ON");
    }

    @Override
    public void stop() {
    }
}
