package com.arobs.internship.week1.lab5.ex2;

public class TestImage {

    public void displayImage() {
        RealImage realImage = new RealImage("RealImage_fileName");
        realImage.display();
        realImage.rotatedImage();

        ProxyImage proxyImage = new ProxyImage("ProxyImage_fileName", realImage);
        proxyImage.display();
        proxyImage.rotatedImage();
    }
}
