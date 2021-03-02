package com.arobs.internship.week1.lab4.ex4;

import com.arobs.internship.week1.lab4.ex2.Author;

import java.util.Arrays;

public class BookPro {
    private String name;
    private Author[] authors;
    private double price;
    private int qtyInStock;

    public BookPro(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public BookPro(String name, Author[] authors, double price, int qtyInStock) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    @Override
    public String toString() {
        return name + " by " + authors.length + " authors.";
    }

    public void printAuthors() {
        System.out.println(Arrays.toString(authors));
    }
}
