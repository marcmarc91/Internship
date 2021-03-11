package com.arobs.internship.week1.lab3.ex4;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(int x, int y) {
        if (x > y) {
            return x - y;
        } else
            return y - x;

    }

    public int distance(MyPoint another) {
        if (distance(x, y) > another.distance(another.x, another.y)) {
            return distance(x, y) - another.distance(another.x, another.y);
        } else
            return another.distance(another.x, another.y) - distance(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }
}
