package com.arobs.internship.library.entity;


import com.arobs.internship.library.entity.types.StatusBookRequest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "book_request")
public class BookRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            fetch = FetchType.LAZY)
    @JoinTable(name = "book_request_author",
            joinColumns = {@JoinColumn(name = "book_request_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> authors;

    @Column(name = "publishing_company", nullable = false, length = 50)
    private String publishingCompany;

    @Column(name = "link_library", length = 100)
    private String linkLibrary;

    @Column(name = "no_copies", nullable = false)
    private int noCopies;

    @Column(name = "total_cost", nullable = false)
    private double totalCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",
            nullable = false,
            columnDefinition = "ENUM('PENDING','ACCEPTED','REJECTED')")
    private StatusBookRequest status;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime date;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getLinkLibrary() {
        return linkLibrary;
    }

    public void setLinkLibrary(String linkLibrary) {
        this.linkLibrary = linkLibrary;
    }

    public int getNoCopies() {
        return noCopies;
    }

    public void setNoCopies(int noCopies) {
        this.noCopies = noCopies;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public StatusBookRequest getStatus() {
        return status;
    }

    public void setStatus(StatusBookRequest status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
