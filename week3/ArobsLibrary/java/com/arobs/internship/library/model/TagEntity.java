package com.arobs.internship.library.model;

import com.arobs.internship.library.utils.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TagEntity extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(TagEntity.class);

    private String word;

    public TagEntity() {
    }

    public TagEntity(int id, String word) {
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
