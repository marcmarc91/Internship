package com.arobs.internship.week1.lab2;

import com.arobs.internship.week1.lab2.ex1.ExerciseOne;
import com.arobs.internship.week1.lab2.ex2.ExerciseTwo;
import com.arobs.internship.week1.lab2.ex3.ExerciseThree;
import com.arobs.internship.week1.lab2.ex4.ExerciseFour;
import com.arobs.internship.week1.lab2.ex5.ExerciseFive;
import com.arobs.internship.week1.lab2.ex6.ExerciseSix;
import com.arobs.internship.week1.lab2.ex7.ExerciseSeven;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberEx = 0;
        do {

            System.out.println("Enter the exercise number (1-7) or 0 to close: ");
            while (!scanner.hasNextInt()) {
                System.out.printf("%s is not valid number. %n", scanner.next());
            }
            numberEx = scanner.nextInt();

            switch (numberEx) {
                case 1:
                    ExerciseOne exerciseOne = new ExerciseOne(scanner);
                    break;
                case 2:
                    ExerciseTwo exerciseTwo = new ExerciseTwo(scanner);
                    break;
                case 3:
                    ExerciseThree exerciseThree = new ExerciseThree(scanner);
                    break;
                case 4:
                    ExerciseFour exerciseFour = new ExerciseFour(scanner);
                    break;
                case 5:
                    ExerciseFive exerciseFive = new ExerciseFive();
                    break;
                case 6:
                    ExerciseSix exerciseSix = new ExerciseSix(scanner);
                    break;
                case 7:
                    ExerciseSeven exerciseSeven = new ExerciseSeven(scanner);
                    break;

            }

        } while (numberEx != 0);
    }
}
