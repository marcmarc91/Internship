package com.arobs.internship.week1.lab4.ex4;


public class TestBookPro {
    private BookPro book;

    public TestBookPro(BookPro book) {
        this.book = book;
    }

    public void displayInfoBook() {
        book.setPrice(book.getPrice() * 1.2);
        book.setQtyInStock(book.getQtyInStock() * 9);

        System.out.println(book);
        book.printAuthors();
    }
}
