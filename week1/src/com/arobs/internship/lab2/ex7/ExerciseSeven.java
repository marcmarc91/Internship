package com.arobs.internship.week1.lab2.ex7;

import java.util.Random;
import java.util.Scanner;

public class ExerciseSeven {
    Scanner scanner;

    public ExerciseSeven(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("Write a “Gues the number” game in Java. Program will generate a random number and will ask user to guess it. " +
                "If user guess the number program will stop. " +
                "If user do not guess it program will display: 'Wrong answer, " +
                "your number it too high' or 'Wrong answer, your number is too low'. " +
                "Program will allow user maximum 3 retries after which will stop with message 'You lost'." + System.lineSeparator());

        Random random = new Random();
        int retries = 3;
        int i = 0;

        int randomNumber = random.nextInt(50);

        for (i = 0; i < retries; i++) {

            System.out.printf("%s/3 Enter the number (between 0 to 50): ", i + 1);
            while (!scanner.hasNextInt()) {
                System.out.printf("%s is not valid number. %n", scanner.next());
            }
            int number = scanner.nextInt();

            if (number == randomNumber) {
                System.out.printf("Correct!!! %n");
                break;
            } else if (number > randomNumber) {
                System.out.printf("Wrong answer, your number it too high %n");
            } else {
                System.out.printf("Wrong answer, your number is too low %n");
            }

        }

        if (i == retries) {
            System.out.printf("You lost. The number was %s.%n", randomNumber);
        }
    }
}
