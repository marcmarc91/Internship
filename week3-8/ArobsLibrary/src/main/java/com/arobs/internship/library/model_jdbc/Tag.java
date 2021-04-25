package com.arobs.internship.library.model_jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tag extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(Tag.class);

    private String word;

    public Tag() {
    }

    public Tag(int id, String word) {
        super(id);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
