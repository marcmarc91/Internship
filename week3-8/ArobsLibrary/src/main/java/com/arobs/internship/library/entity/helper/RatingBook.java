package com.arobs.internship.library.entity.helper;

import com.arobs.internship.library.exceptions.EnumValidationException;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum RatingBook {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);
    private final int value;

    private RatingBook(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static RatingBook create(int value) throws EnumValidationException {
        String t = String.valueOf(value);
        for (RatingBook rating : values()) {
            if (value == (rating.getValue())) {
                return rating;
            }
        }
        throw new EnumValidationException(String.valueOf(value), "bookRating", Arrays.stream(values()).map(RatingBook::getValue).toArray());
    }
}
