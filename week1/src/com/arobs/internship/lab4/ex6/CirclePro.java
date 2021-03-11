package com.arobs.internship.week1.lab4.ex6;

public class CirclePro extends Shape {
    private double radius;

    public CirclePro() {
        super();
        radius = 1.0;
    }

    public CirclePro(double radius) {
        super();
        this.radius = radius;
    }

    public CirclePro(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius=" + radius
                + ", which is a subclass of " + super.toString();

    }
}
