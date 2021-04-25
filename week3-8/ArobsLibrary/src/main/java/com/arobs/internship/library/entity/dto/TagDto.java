package com.arobs.internship.library.entity.dto;

import javax.validation.constraints.NotBlank;

public class TagDto {
    private Integer id;
    @NotBlank
    private String word;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
