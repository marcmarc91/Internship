package com.arobs.internship.library.exceptions;

public class EntityMustNotBeModifiedException extends RuntimeException {
    private int id;

    public EntityMustNotBeModifiedException(String message, int id) {
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
