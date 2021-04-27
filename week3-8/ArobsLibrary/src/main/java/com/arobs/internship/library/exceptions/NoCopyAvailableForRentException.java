package com.arobs.internship.library.exceptions;

public class NoCopyAvailableForRentException extends RuntimeException {

    private int bookId;

    public NoCopyAvailableForRentException(String message, int bookId) {
        super(message);
        this.bookId = bookId;
    }

    public NoCopyAvailableForRentException(int bookId) {
        super("There are currently no copies available for this");
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

}
