package com.arobs.internship.library.exceptions;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ErrorObj {
    private Date timestamp;
    private int status;
    private String error;
    private List<String> messages;
    private int id;

    public ErrorObj() {
    }

    public ErrorObj(Date timestamp, int status, String error, int id, List<String> messages) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.messages = messages;
        this.id = id;
    }

    public ErrorObj(Date timestamp, int status, String error, String message, int id) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.messages = Collections.singletonList(message);
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setMessage(String message) {
        messages = Collections.singletonList(message);
    }
}
