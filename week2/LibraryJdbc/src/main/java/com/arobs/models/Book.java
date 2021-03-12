package com.arobs.models;

import java.sql.Date;

public class Book {
    private int id;
    private String title;
    private Date publishDate;
    private float price;
    private Author author;

    public Book() {
    }

    public Book(int id, String title, Date publishDate, float price, Author author) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.price = price;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
