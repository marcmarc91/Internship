package com.arobs.internship.week1.lab3.ex5;

public class Flower {
    int petal;
    static int countObjects;

    Flower() {
        System.out.println("Flower has been created!");
        countObjects++;
    }

    public static int getConstructedObjects() {
        return countObjects;
    }

    public static void main(String[] args) {
        Flower[] garden = new Flower[5];
        for (int i = 0; i < 5; i++) {
            Flower f = new Flower();
            garden[i] = f;
        }
        System.out.printf("The number of constructed objects: %s%n", getConstructedObjects());
    }


}
