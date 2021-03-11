package com.arobs.internship.week1.lab5.ex1;


public class TestShapeFive {

    public void displayShape() {
        CircleFive circlePro = new CircleFive("black", false, 5.4);
        System.out.printf("Circle color: %s%n", circlePro.getColor());
        System.out.printf("Circle filled: %s%n", circlePro.isFilled());
        System.out.printf("Circle area: %s%n", circlePro.getArea());
        System.out.printf("Circle perimeter: %s%n", circlePro.getPerimeter());
        System.out.printf("Circle radius: %s%n", circlePro.getRadius());
        System.out.println(circlePro + System.lineSeparator());

        RectangleFive rectangle = new RectangleFive("pink", true, 7.5, 2.5);
        System.out.printf("Rectangle color: %s%n", rectangle.getColor());
        System.out.printf("Rectangle filled: %s%n", rectangle.isFilled());
        System.out.printf("Rectangle area: %s%n", rectangle.getArea());
        System.out.printf("Rectangle perimeter: %s%n", rectangle.getPerimeter());
        System.out.printf("Rectangle length: %s%n", rectangle.getLength());
        System.out.printf("Rectangle width: %s%n", rectangle.getWidth());
        System.out.println(rectangle + System.lineSeparator());

        SquareFive square = new SquareFive("blue", false, 6.5);
        System.out.printf("Square color: %s%n", square.getColor());
        System.out.printf("Square filled: %s%n", square.isFilled());
        System.out.printf("Square area: %s%n", square.getArea());
        System.out.printf("Square perimeter: %s%n", square.getPerimeter());
        System.out.printf("Square length: %s%n", square.getLength());
        System.out.printf("Square width: %s%n", square.getWidth());
        System.out.printf("Square sides: %s%n", square.getSide());
        System.out.println(square + System.lineSeparator());

    }
}
