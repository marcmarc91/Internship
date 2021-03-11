package com.arobs.internship.week1.lab5.ex1;

public class CircleFive extends ShapeFive {
    protected double radius;

    public CircleFive() {
        radius = 1.0;
    }

    public CircleFive(double radius) {
        this.radius = radius;
    }

    public CircleFive(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "CircleFive{" +
                "radius=" + radius +
                '}' + super.toString();
    }
}
