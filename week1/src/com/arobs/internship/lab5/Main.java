package com.arobs.internship.week1.lab5;

import com.arobs.internship.week1.lab5.ex1.TestShapeFive;
import com.arobs.internship.week1.lab5.ex2.TestImage;
import com.arobs.internship.week1.lab5.ex3.Controller;
import com.arobs.internship.week1.lab5.ex3.LightSensor;
import com.arobs.internship.week1.lab5.ex3.TemperatureSensor;
import com.arobs.internship.week1.lab5.ex4.ControllerSingleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberEx = 0;

        do {
            System.out.println("Enter the exercise number (1-4) or 0 to close: ");
            while (!scanner.hasNextInt()) {
                System.out.printf("%s is not valid number. %n", scanner.next());
            }
            numberEx = scanner.nextInt();
            switch (numberEx) {
                case 1:
                    TestShapeFive testShapeFive = new TestShapeFive();
                    testShapeFive.displayShape();
                    break;
                case 2:
                    TestImage testImage = new TestImage();
                    testImage.displayImage();
                    break;
                case 3:
                    Controller controller = new Controller();
                    controller.setLightSensor(new LightSensor("New York"));
                    controller.setTemperatureSensor(new TemperatureSensor("Paris"));
                    controller.control();
                    break;
                case 4:
                    ControllerSingleton controllerSingleton = ControllerSingleton.getControllerSingleton();
                    controllerSingleton.setLightSensor(new LightSensor("Cluj"));
                    controllerSingleton.setTemperatureSensor(new TemperatureSensor("Bucuresti"));
                    controllerSingleton.control();
                    break;
            }

        } while (numberEx != 0);
    }
}
