package com.arobs.internship.week1.lab7.ex4;

import java.io.*;

public class Car implements Serializable {
    private String model;
    private int price;

    public Car() {
        model = "Skoda";
        price = 7000;
    }

    public Car(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void serialize() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("car.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car deserialize() {
        Car car = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("car.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            car = (Car) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
