package com.arobs.internship.week1.lab5.ex1;

public abstract class ShapeFive {
    protected String color;
    protected boolean filled;

    public ShapeFive() {
        color = "red";
        filled = false;
    }

    public ShapeFive(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }


    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
