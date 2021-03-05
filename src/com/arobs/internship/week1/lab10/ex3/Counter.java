package com.arobs.internship.week1.lab10.ex3;

public class Counter extends Thread {
    int startIndex;
    int stopIndex;

    public Counter(int startIndex, int stopIndex) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
    }

    @Override
    public void run() {
        System.out.printf("Current Thread: %s%n", Thread.currentThread().getName());
        int count = startIndex;
        for (int i = startIndex; i <= stopIndex; i++) {
            count = i;
            System.out.println(count);
        }
    }
}
