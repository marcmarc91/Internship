package com.arobs.internship.library.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseEntity {

    private int id;

    public BaseEntity() {
    }

    public BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
