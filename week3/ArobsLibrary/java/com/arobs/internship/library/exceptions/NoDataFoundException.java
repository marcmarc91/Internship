package com.arobs.internship.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoDataFoundException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(NoDataFoundException.class);
    private int id;

    public NoDataFoundException(String message, int id) {
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
