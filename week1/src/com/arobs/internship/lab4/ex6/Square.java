package com.arobs.internship.week1.lab4.ex6;

public class Square extends Rectangle{

    public Square() {
        super();
        double side = 1.0;
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled, side, side);
        side = side;
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public double getArea() {
        return Math.pow(getSide(), 2);
    }

    public double getPerimeter() {
        return 4 * getSide();
    }

    public String toString() {
        return "A Square with side = " + getSide() + ", which is a subclass of " + super.toString();
    }
    
}
