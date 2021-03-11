package com.arobs.internship.week1.lab2.ex5;

import java.util.Arrays;
import java.util.Random;

public class ExerciseFive {


    public ExerciseFive() {
        System.out.println("Write a program which generate a vector of 10 int elements, " +
                "sort them using bubble sort method and then display the result." + System.lineSeparator());

        Random random = new Random();
        int maxElements = 10;
        int[] vector = new int[maxElements];
        int temp;
        for (int i = 0; i < maxElements; i++) {
            vector[i] = random.nextInt(500);
        }
        System.out.printf("Generated vector: %s%n", Arrays.toString(vector));
        for (int i = 0; i < maxElements - 1; i++) {
            for (int j = 0; j < maxElements - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }

        }
        System.out.printf("Sorted vector: %s%n", Arrays.toString(vector));

    }
}
