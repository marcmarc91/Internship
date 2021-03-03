package com.arobs.internship.week1.lab5.ex1;

public class SquareFive extends RectangleFive {

    public SquareFive() {
        super();
        double side = 2;
    }

    public SquareFive(double side) {
        super(side, side);
    }

    public SquareFive(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double side) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "SquareFive{side= }" + getSide() + super.toString();
    }
}
