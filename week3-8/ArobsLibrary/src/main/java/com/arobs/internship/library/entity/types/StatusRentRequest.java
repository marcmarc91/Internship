package com.arobs.internship.library.entity.helper;


import com.arobs.internship.library.exceptions.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusRentRequest {
    WAITING_FOR_AVAILABLE("WAITING_FOR_AVAILABLE"),
    WAITING_FOR_CONFIRMATION("WAITING_FOR_CONFIRMATION"),
    DECLINED("DECLINED"),
    GRANTED("GRANTED");

    private final String status;

    StatusRentRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static StatusRentRequest create(String value) throws EnumValidationException {
        if (value == null) {
            throw new EnumValidationException(value, "status", values());
        }
        for (StatusRentRequest status : values()) {
            if (value.equals(status.getStatus())) {
                return status;
            }
        }
        throw new EnumValidationException(value, "status", values());
    }
}
