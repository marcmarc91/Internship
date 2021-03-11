package com.arobs.internship.week1.lab3.ex4;

public class TestMyPoint {

    public TestMyPoint() {

        MyPoint myPoint = new MyPoint(9, 16);

        MyPoint anotherPoint = new MyPoint();
        anotherPoint.setX(10);
        anotherPoint.setY(7);

        System.out.printf("The distance between the points of myPoint: %s%n",
                myPoint.distance(myPoint.getX(), myPoint.getY()));

        myPoint.setXY(23, 4);
        System.out.printf("The distance between the points of myPoint and anotherPoint: %s%n",
                myPoint.distance(anotherPoint));
    }
}
