package com.roman.shilov.hw17.travelagency.countries.service.exceptions;

import com.roman.shilov.hw17.travelagency.common.buisness.exceptions.BasicTravelCheckedException;

public class CountryIsContainedInSomeOrdersException extends BasicTravelCheckedException {
    public CountryIsContainedInSomeOrdersException(String message, int code) {
        super(message, code);
    }
}
