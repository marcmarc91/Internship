package com.arobs.internship.library.entity.dto;

import com.arobs.internship.library.entity.helper.StatusBookRent;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class BookRentDto {
    private Integer id;
    @NotNull
    private Integer idEmployee;
    @NotNull
    private Integer idBook;
    private UUID idCopy;
//    private LocalDateTime rentalDate;
//    private LocalDateTime returnDate;
    @NotNull
    private StatusBookRent status;
    @Min(0)
    @Max(5)
    private int bookRating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public UUID getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(UUID idCopy) {
        this.idCopy = idCopy;
    }

//    public LocalDateTime getRentalDate() {
//        return rentalDate;
//    }
//
//    public void setRentalDate(LocalDateTime rentalDate) {
//        this.rentalDate = rentalDate;
//    }
//
//    public LocalDateTime getReturnDate() {
//        return returnDate;
//    }
//
//    public void setReturnDate(LocalDateTime returnDate) {
//        this.returnDate = returnDate;
//    }

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
