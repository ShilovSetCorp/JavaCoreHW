package com.roman.shilov.hw11.travelagency.common.buisness.exceptions;

public class BasicTravelCheckedException extends Exception {
    private int code;

    public BasicTravelCheckedException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
