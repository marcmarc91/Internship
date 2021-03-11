package com.arobs.internship.week1.lab10.ex4;

import java.util.Random;

public class Robot extends Thread {
    int x;
    int y;
    Random random;
    int timer;

    public Robot(int x, int y, int timer, String name) {
        super(name );
        this.x = x;
        this.y = y;
        this.timer = timer;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
    }
}
