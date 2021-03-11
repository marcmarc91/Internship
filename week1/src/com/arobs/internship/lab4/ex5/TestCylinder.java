package com.arobs.internship.week1.lab4.ex5;

import com.arobs.internship.week1.lab3.ex2.Circle;

public class TestCylinder {
    private Cylinder cylinder;

    public TestCylinder(Cylinder cylinder) {
        this.cylinder = cylinder;
    }

    public void diplayCylinder() {
        System.out.printf("Radius: %s%n", cylinder.getRadius());
        System.out.printf("Height: %s%n", cylinder.getHeight());
        System.out.printf("Area: %s%n", cylinder.getArea());
    }
}
