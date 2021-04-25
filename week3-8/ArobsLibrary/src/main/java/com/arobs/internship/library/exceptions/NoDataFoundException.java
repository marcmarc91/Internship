package com.arobs.internship.library.exceptions;

public class NoDataFoundException extends RuntimeException {

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
