package com.arobs.internship.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorObj {

    private int status;

    private String message;

    private long timestamp;

    private int id;

    public ErrorObj() {
    }

    public ErrorObj(int status, String message, long timestamp, int id) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
