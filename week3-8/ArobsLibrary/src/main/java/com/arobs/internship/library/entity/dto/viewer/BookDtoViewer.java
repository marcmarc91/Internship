package com.arobs.internship.library.entity.dto.viewer;


import com.arobs.internship.library.entity.dto.AuthorDto;
import com.arobs.internship.library.entity.dto.TagDto;

import java.time.LocalDate;
import java.util.List;

public class BookDtoViewer {
    private Integer id;
    private String title;
    private String description;
    private LocalDate dateAdded;
    private List<AuthorDto> authors;
    private List<TagDto> tags;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }

}
