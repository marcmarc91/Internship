package com.arobs.internship.library.entity;


import com.arobs.internship.library.entity.types.StatusRentRequest;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rent_request")
public class RentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "date", nullable = false)
    private LocalDateTime requestDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            nullable = false,
            columnDefinition = "ENUM('WAITING_FOR_AVAILABLE','WAITING_FOR_CONFIRMATION','DECLINED','GRANTED')")
    private StatusRentRequest status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_rent_id")
    private BookRent bookRent;

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
