package com.arobs.internship.library.exceptions;

public class LimitedAccessException extends RuntimeException {
    private int id;

    public LimitedAccessException(String message, int id) {
        super(message);
        this.id = id;
    }

    public LimitedAccessException(int id) {
        super("You do not have access to this operation " + id);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
