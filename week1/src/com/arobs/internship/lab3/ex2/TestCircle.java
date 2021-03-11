package com.arobs.internship.week1.lab3.ex2;

public class TestCircle {
    Circle circle;

    public TestCircle(Circle circle) {
        this.circle = circle;

        System.out.printf("Radius: %s%n", circle.getRadius());
        System.out.printf("Area: %s%n", circle.getArea());

    }
}
