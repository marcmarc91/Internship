package com.arobs.internship.library.exceptions;

public class EnumValidationException extends Exception {

    private String enumValue = null;
    private String enumName = null;
    private Object[] enumValues = null;

    public EnumValidationException(String enumValue, String enumName, Object[] enumValues) {
        this.enumValue = enumValue;
        this.enumName = enumName;
        this.enumValues = enumValues;
    }

    public EnumValidationException(Throwable cause, String enumValue, String enumName, Object[] enumValues) {
        super(cause);
        this.enumValue = enumValue;
        this.enumName = enumName;
        this.enumValues = enumValues;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public Object[] getEnumValues() {
        return enumValues;
    }

    public void setEnumValues(Object[] enumValues) {
        this.enumValues = enumValues;
    }
}
