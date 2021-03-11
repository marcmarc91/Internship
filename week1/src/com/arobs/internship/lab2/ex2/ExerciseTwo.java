package com.arobs.internship.week1.lab2.ex2;

import java.util.Scanner;

public class ExerciseTwo {

    Scanner scanner;
    int number;

    public ExerciseTwo(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("Exercise PrintNumberInWord (nested-if, switch-case): " +
                "Write a program called PrintNumberInWord which prints “ONE”, “TWO”,… , “NINE”, “OTHER” if the int variable “number” is 1, 2,… , 9, or other, respectively. " +
                "Use (a) a “nested-if” statement; (b) a “switch-case” statement." + System.lineSeparator());

        System.out.println("Enter the number:");
        while (!scanner.hasNextInt()) {
            System.out.printf("%s is not valid number. %n", scanner.next());
        }
        number = scanner.nextInt();
        System.out.printf("Printing using IF: %s%n", printNumberInWordUsingIf(number));
        System.out.printf("Printing using SWITCH: %s%n", printNumberInWordUsingSwitch(number));
    }

    public String printNumberInWordUsingIf(int number) {
        if (number == 1)
            return "ONE";
        else if (number == 2)
            return "TWO";
        else if (number == 3)
            return "THREE";
        else if (number == 4)
            return "FOUR";
        else if (number == 5)
            return "FIVE";
        else if (number == 6)
            return "SIX";
        else if (number == 7)
            return "SEVEN";
        else if (number == 8)
            return "EIGHT";
        else if (number == 9)
            return "NINE";
        else
            return "OTHER";
    }

    public String printNumberInWordUsingSwitch(int number) {
        switch (number) {
            case 1:
                return "ONE";
            case 2:
                return "TWO";
            case 3:
                return "THREE";
            case 4:
                return "FOUR";
            case 5:
                return "FIVE";
            case 6:
                return "SIX";
            case 7:
                return "SEVEN";
            case 8:
                return "EIGHT";
            case 9:
                return "NINE";
            default:
                return "OTHER";
        }
    }
}
