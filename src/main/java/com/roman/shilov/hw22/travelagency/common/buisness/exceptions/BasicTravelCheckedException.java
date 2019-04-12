package com.roman.shilov.hw22.travelagency.common.buisness.exceptions;

public abstract class BasicTravelCheckedException extends Exception {
    private int code;

    public BasicTravelCheckedException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
