package com.arobs.internship.library.exceptions;

public class ExtensionPeriodLimitExceededException extends RuntimeException {
    private int idRentBook;

    public ExtensionPeriodLimitExceededException(String message, int idRentBook) {
        super(message);
        this.idRentBook = idRentBook;
    }

    public ExtensionPeriodLimitExceededException(int idRentBook) {
        super("The 3-month book rental limit has been reached ");
        this.idRentBook = idRentBook;
    }

    public int getIdRentBook() {
        return idRentBook;
    }

    public void setIdRentBook(int idRentBook) {
        this.idRentBook = idRentBook;
    }
}
