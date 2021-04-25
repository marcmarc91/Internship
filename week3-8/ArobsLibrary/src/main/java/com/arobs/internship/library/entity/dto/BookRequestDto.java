package com.arobs.internship.library.entity.dto;

import com.arobs.internship.library.entity.helper.StatusBookRequest;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;

public class BookRequestDto {
    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private Set<Integer> idAuthors;
    @NotBlank
    private String publishingCompany;
    private String linkLibrary;
    @Positive
    @Min(1)
    private int noCopies;
    @NotNull
    @Positive
    private double totalCost;
    @NotNull
    private StatusBookRequest status;
    @PastOrPresent
    private LocalDateTime date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Integer> getIdAuthors() {
        return idAuthors;
    }

    public void setIdAuthors(Set<Integer> idAuthors) {
        this.idAuthors = idAuthors;
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
