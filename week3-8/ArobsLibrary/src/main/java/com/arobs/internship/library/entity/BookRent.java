package com.arobs.internship.library.entity;

import com.arobs.internship.library.entity.helper.StatusBookRent;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_rent")
public class BookRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
//    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "copy_id", nullable = false)
    private Copy copy;

    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            nullable = false,
            columnDefinition = "ENUM('ON_GOING','LATE','RETURNED')")
    private StatusBookRent status;

    @Column(name = "rating")
    private int bookRating;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
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
