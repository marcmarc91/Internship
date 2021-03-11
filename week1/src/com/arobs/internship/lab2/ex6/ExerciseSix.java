package com.arobs.internship.week1.lab2.ex6;

import java.util.Scanner;

public class ExerciseSix {
    Scanner scanner;

    public ExerciseSix(Scanner scanner) {
        this.scanner = scanner;
        System.out.printf("Being given an int number N, compute N! using 2 methods:%n %s%n %s%n",
                "1. a non recursive method", "2. a recursive method");


        System.out.println("Enter the number:");
        while (!scanner.hasNextInt()) {
            System.out.printf("%s is not valid number. %n", scanner.next());
        }
        int number = scanner.nextInt();

        System.out.printf("Result from NON recursive method: %s%n", nonRecursiveCompute(number));
        System.out.printf("Result from recursive method: %s%n", recursiveCompute(number));

    }

    private int nonRecursiveCompute(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private int recursiveCompute(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * recursiveCompute(number - 1);
        }
    }
}
