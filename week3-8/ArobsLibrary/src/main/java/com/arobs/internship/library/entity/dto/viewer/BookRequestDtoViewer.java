package com.arobs.internship.library.entity.dto.viewer;

import com.arobs.internship.library.entity.dto.AuthorDto;
import com.arobs.internship.library.entity.types.StatusBookRequest;

import java.time.LocalDateTime;
import java.util.List;

public class BookRequestDtoViewer {
    private Integer id;
    private String title;
    private List<AuthorDto> authors;
    private String publishingCompany;
    private String linkLibrary;
    private int noCopies;
    private double totalCost;
    private StatusBookRequest status;
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

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
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
