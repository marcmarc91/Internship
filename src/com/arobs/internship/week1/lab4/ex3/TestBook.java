package com.arobs.internship.week1.lab4.ex3;

public class TestBook {
    private Book book;

    public TestBook(Book book) {
        this.book = book;
    }

    public void displayBook() {
        book.setPrice(book.getPrice() * 2);
        book.setQtyInStock(book.getQtyInStock() * 12);

        System.out.println(book);
    }
}
