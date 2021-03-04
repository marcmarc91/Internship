package com.arobs.internship.week1.lab7.ex1;

public class CountCoffeeException extends Exception {
    private int limit;

    public CountCoffeeException(String message, int limit) {
        super(message);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
