package com.arobs.internship.week1.lab5.ex1;

public class RectangleFive extends ShapeFive {
    protected double width;
    protected double length;

    public RectangleFive() {
        width = 2.9;
        length = 4.5;
    }

    public RectangleFive(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public RectangleFive(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}' + super.toString();
    }
}
