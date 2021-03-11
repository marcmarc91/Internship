package com.arobs.internship.week1.lab3.ex1;

public class Robot {
    private int x;

    public Robot() {
        this.x = 1;
    }

    public void change(int k) {
        if (k >= 1) {
            this.x = x + k;
        }
    }

    @Override
    public String toString() {
        return "The position of the robot " +
                this.x;
    }
}
