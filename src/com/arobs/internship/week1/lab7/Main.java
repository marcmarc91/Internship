package com.arobs.internship.week1.lab7;

import com.arobs.internship.week1.lab7.ex2.CountChar;
import com.arobs.internship.week1.lab7.ex3.EncDec;
import com.arobs.internship.week1.lab7.ex4.Car;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberEx = 0;

        do {
            System.out.println("Enter the exercise number (2-4) or 0 to close: ");
            while (!scanner.hasNextInt()) {
                System.out.printf("%s is not valid number. %n", scanner.next());
            }
            numberEx = scanner.nextInt();
            switch (numberEx) {
                case 2:
                    System.out.println("Enter the char: ");
                    char c = scanner.next().charAt(0);
                    CountChar countChar = new CountChar();
                    System.out.printf("The file contains: %s chars. %n", countChar.countChar("listChar.txt", c));
                    break;
                case 3:
                    EncDec encDec = new EncDec();
                    encDec.encrypt("encDec");
                    encDec.decrypt("encDec");
                    break;
                case 4:
                    Car car = new Car("Dacia", 4000);
                    car.serialize();

                    Car carDes = Car.deserialize();
                    System.out.println(carDes);
                    break;
            }

        } while (numberEx != 0);
    }
}
