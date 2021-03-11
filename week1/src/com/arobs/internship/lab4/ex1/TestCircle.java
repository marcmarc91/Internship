package com.arobs.internship.week1.lab4.ex1;

public class TestCircle {
    Circle circle;

    public TestCircle(Circle circle) {
        this.circle = circle;
    }

    public void displayInfo() {
        System.out.printf("Radius: %s%n", circle.getRadius());
        System.out.printf("Area: %s%n", circle.getArea());
    }
}
