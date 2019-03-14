package com.roman.shilov.hw11.travelagency.common.buisness.exceptions;

public class BasicTravelUncheckedException extends RuntimeException {
    private int code;

    public int getCode() {
        return code;
    }

    public BasicTravelUncheckedException(String message, int code) {
        super(message);
        this.code = code;
    }
}
