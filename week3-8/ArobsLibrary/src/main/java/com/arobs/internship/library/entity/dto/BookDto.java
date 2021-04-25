package com.arobs.internship.library.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class BookDto {
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotEmpty
    private Set<Integer> authors;
    @NotEmpty
    private Set<Integer> tags;

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

    public Set<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Integer> authors) {
        this.authors = authors;
    }

    public Set<Integer> getTags() {
        return tags;
    }

    public void setTags(Set<Integer> tags) {
        this.tags = tags;
    }

}
