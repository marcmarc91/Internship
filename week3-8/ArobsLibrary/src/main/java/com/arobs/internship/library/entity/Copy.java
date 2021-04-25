package com.arobs.internship.library.entity;

import com.arobs.internship.library.entity.helper.StatusCopy;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "copy")
public class Copy {

    @Id
    @GeneratedValue()
    @Column(name = "code", columnDefinition = "binary(16)", nullable = false)
    private UUID code;

    @Column(name = "flag", columnDefinition = "tinyint(1) default 1")
    private boolean flag;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            nullable = false,
            columnDefinition = "ENUM('AVAILABLE','RENTED','PENDING')")
    private StatusCopy status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    public void setCode(UUID code) {
        this.code = code;
    }

    public UUID getCode() {
        return code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public StatusCopy getStatus() {
        return status;
    }

    public void setStatus(StatusCopy status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
