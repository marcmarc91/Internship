package com.arobs.internship.library.entity.helper;

import com.arobs.internship.library.exceptions.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusBookRequest {
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED");

    private final String status;

    StatusBookRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static StatusBookRequest create(String value) throws EnumValidationException {
        if (value == null) {
            throw new EnumValidationException(value, "status", values());
        }
        for (StatusBookRequest status : values()) {
            if (value.equals(status.getStatus())) {
                return status;
            }
        }
        throw new EnumValidationException(value, "status", values());
    }
}
