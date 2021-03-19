package com.arobs.internship.library.model;

import com.arobs.internship.library.utils.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorEntity extends BaseEntity {
    private static final Logger log = LoggerFactory.getLogger(AuthorEntity.class);

    private String name;

    public AuthorEntity() {
    }

    public AuthorEntity(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
