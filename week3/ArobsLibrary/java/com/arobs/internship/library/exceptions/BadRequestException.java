package com.arobs.internship.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadRequestException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(BadRequestException.class);
    private int id;

    public BadRequestException(String message, int id) {
        super(message);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
