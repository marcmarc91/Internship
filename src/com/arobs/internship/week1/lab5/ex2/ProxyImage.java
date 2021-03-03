package com.arobs.internship.week1.lab5.ex2;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName, RealImage realImage) {
        this.fileName = fileName;
        this.realImage = realImage;
        realImage.display();
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

    @Override
    public void rotatedImage() {
        System.out.printf("Display rotated %s%n", fileName);
    }
}
