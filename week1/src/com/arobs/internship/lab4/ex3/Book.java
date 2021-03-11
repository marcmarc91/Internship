package com.arobs.internship.week1.lab4.ex3;

import com.arobs.internship.week1.lab4.ex2.Author;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;

    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = 0;
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

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    @Override
    public String toString() {
        return name + " by " + author;
    }
}
