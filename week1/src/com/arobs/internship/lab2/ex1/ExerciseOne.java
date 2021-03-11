package com.arobs.internship.week1.lab2.ex1;

import java.util.Scanner;

public class ExerciseOne {
    Scanner scanner;

    public ExerciseOne(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("Write a program which reads 2 numbers from keyboard and " +
                "display the maximum between them." + System.lineSeparator());

        System.out.println("Enter the first number:");
        while (!scanner.hasNextInt()) {
            System.out.printf("%s is not valid number. %n", scanner.next());
        }
        int firstNumber = scanner.nextInt();

        System.out.println("Enter the second number:");
        while (!scanner.hasNextInt()) {
            System.out.printf("%s is not valid number. %n", scanner.next());
        }
        int secondNumber = scanner.nextInt();

        int max = 0;
        if (firstNumber > secondNumber) {
            max = firstNumber;
        } else {
            max = secondNumber;
        }
        System.out.printf("The maximum number: %s%n", max);
    }
}
