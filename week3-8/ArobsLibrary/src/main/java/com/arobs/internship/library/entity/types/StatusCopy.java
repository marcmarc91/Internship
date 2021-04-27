package com.arobs.internship.library.entity.types;

import com.arobs.internship.library.exceptions.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusCopy {
    AVAILABLE("AVAILABLE"),
    RENTED("RENTED"),
    PENDING("PENDING");

    private final String status;

    StatusCopy(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static StatusCopy create(String value) throws EnumValidationException {
        if (value == null) {
            throw new EnumValidationException(value, "status", values());
        }
        for (StatusCopy status : values()) {
            if (value.equals(status.getStatus())) {
                return status;
            }
        }
        throw new EnumValidationException(value, "status", values());
    }
}
