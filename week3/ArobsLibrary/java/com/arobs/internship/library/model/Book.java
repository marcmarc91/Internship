package com.arobs.internship.library.model;

import com.arobs.internship.library.utils.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

public class Book extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(Book.class);

    private String title;
    private String author;
    private String description;
    private String tags;
    private Date dateAdded;

    public Book() {
    }

    public Book(String title, String author, String description, String tags, Date dateAdded) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.tags = tags;
        this.dateAdded = dateAdded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
