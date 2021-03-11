package com.arobs.internship.week1.lab4.ex5;

import com.arobs.internship.week1.lab4.ex1.Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * Math.pow(getRadius(), 2) + height * (2 * Math.PI * getRadius());
    }
}
