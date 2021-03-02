package com.arobs.internship.week1.lab4.ex1;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        this(1.0, "red");
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
