package com.arobs.internship.library.entity.types;


import com.arobs.internship.library.exceptions.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusBookRent {
    ON_GOING("ON_GOING"),
    LATE("LATE"),
    RETURNED("RETURNED");

    private final String status;

    StatusBookRent(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static StatusBookRent create(String value) throws EnumValidationException {
        if (value == null) {
            throw new EnumValidationException(value, "status", values());
        }
        for (StatusBookRent status : values()) {
            if (value.equals(status.getStatus())) {
                return status;
            }
        }
        throw new EnumValidationException(value, "status", values());
    }
}
