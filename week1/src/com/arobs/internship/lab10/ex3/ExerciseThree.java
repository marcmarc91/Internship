package com.arobs.internship.week1.lab10.ex3;

public class ExerciseThree {

    public static void main(String[] args) {
        Counter c1 = new Counter(0, 100);
        Counter c2 = new Counter(100, 200);

        System.out.printf("Current Thread: %s%n", Thread.currentThread().getName());
        c1.start();
        try {
            c1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Current Thread: %s%n", Thread.currentThread().getName());
        c2.start();

    }
}
