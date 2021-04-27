package com.arobs.internship.library.entity.dto.viewer;

import com.arobs.internship.library.entity.BookRent;
import com.arobs.internship.library.entity.dto.EmployeeDto;
import com.arobs.internship.library.entity.types.StatusRentRequest;

import java.time.LocalDateTime;

public class RentRequestDtoViewer {
    private Integer id;
    private EmployeeDto employee;
    private BookDtoViewer book;
    private LocalDateTime requestDate;
    private StatusRentRequest status;
    private BookRent bookRent;

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

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public StatusRentRequest getStatus() {
        return status;
    }

    public void setStatus(StatusRentRequest status) {
        this.status = status;
    }

    public BookRent getBookRent() {
        return bookRent;
    }

    public void setBookRent(BookRent bookRent) {
        this.bookRent = bookRent;
    }
}
