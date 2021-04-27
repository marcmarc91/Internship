package com.arobs.internship.library.entity.dto.viewer;

import com.arobs.internship.library.entity.dto.EmployeeDto;
import com.arobs.internship.library.entity.types.StatusBookRent;

import java.time.LocalDateTime;


public class BookRentDtoViewer {
    private Integer id;
    private EmployeeDto employee;
    private BookDtoViewer book;
    private CopyDtoViewer copy;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private StatusBookRent status;
    private int bookRating;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public BookDtoViewer getBook() {
        return book;
    }

    public void setBook(BookDtoViewer book) {
        this.book = book;
    }

    public CopyDtoViewer getCopy() {
        return copy;
    }

    public void setCopy(CopyDtoViewer copy) {
        this.copy = copy;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public StatusBookRent getStatus() {
        return status;
    }

    public void setStatus(StatusBookRent status) {
        this.status = status;
    }

    public int getBookRating() {
        return bookRating;
    }

    public void setBookRating(int bookRating) {
        this.bookRating = bookRating;
    }
}
