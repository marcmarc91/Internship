package com.arobs.internship.library.entity.helper;

import com.arobs.internship.library.exceptions.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum RoleType {
    ADMIN("ADMIN"),
    REGULAR("REGULAR");

    private final String type;

    RoleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @JsonCreator
    public static RoleType create(String value) throws EnumValidationException {
        if (value == null) {
            throw new EnumValidationException(value, "role", values());
        }
        for (RoleType role : values()) {
            if (value.equals(role.getType())) {
                return role;
            }
        }
        throw new EnumValidationException(value, "role", values());
    }
}
