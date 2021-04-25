package com.arobs.internship.library.model_jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Author extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(Author.class);

    private String name;

    public Author() {
    }

    public Author(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
