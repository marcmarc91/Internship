package com.arobs.internship.week1.lab2.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseThree {
    Scanner scanner;

    public ExerciseThree(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("Write a program which display prime numbers between A and B, where A and B are read from console. " +
                "Display also how many prime numbers have been found." + System.lineSeparator());

        System.out.println("Enter the first number (A): ");
        while (!scanner.hasNextInt()) {
            System.out.printf("%s is not valid number. %n", scanner.next());
        }
        int firstNumber = scanner.nextInt();

        System.out.println("Enter the second number (B): ");
        while (!scanner.hasNextInt()) {
            System.out.printf("%s is not valid number. %n", scanner.next());
        }
        int secondNumber = scanner.nextInt();

        List<Integer> primeNumbers;
        if (firstNumber < secondNumber) {
            primeNumbers = showPrime(firstNumber, secondNumber);
        } else {
            primeNumbers = showPrime(secondNumber, firstNumber);
        }

        System.out.printf("List of prime numbers: %s%n", primeNumbers);
        System.out.printf("Total elements: %s%n", primeNumbers.size());

    }

    private List<Integer> showPrime(int firstNumber, int secondNumber) {

        List<Integer> list = new ArrayList<>();
        for (int i = firstNumber; i <= secondNumber; i++) {
            if (divisors(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean divisors(int number) {
        for (int d = 2; d < number / 2; d++) {
            if (number % d == 0) {
                return false;
            }
        }
        return true;
    }
}
