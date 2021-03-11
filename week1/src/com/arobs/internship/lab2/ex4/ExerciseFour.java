package com.arobs.internship.week1.lab2.ex4;

import java.util.Scanner;

public class ExerciseFour {
    Scanner scanner;

    public ExerciseFour(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("Giving a vector of N elements, display the maximum element in the vector." + System.lineSeparator());

        System.out.println("Enter the vector (comma separated elements): ");
        String[] strVector = scanner.next().split(",");

        int[] intVector = new int[strVector.length];
        for (int i = 0; i < strVector.length; i++) {
            intVector[i] = Integer.parseInt(strVector[i]);
        }

        int max = intVector[0];
        for (int j : intVector) {
            if (j > max) {
                max = j;
            }
        }

        System.out.printf("Maximum element: %s%n", max);

//        System.out.println(Arrays.stream(intVector).summaryStatistics().getMax());
    }
}
