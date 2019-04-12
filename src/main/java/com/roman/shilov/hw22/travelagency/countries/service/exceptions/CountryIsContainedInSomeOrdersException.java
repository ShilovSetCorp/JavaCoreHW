package com.roman.shilov.hw22.travelagency.countries.service.exceptions;

import com.roman.shilov.hw22.travelagency.common.buisness.exceptions.BasicTravelCheckedException;

public class CountryIsContainedInSomeOrdersException extends BasicTravelCheckedException {
    public CountryIsContainedInSomeOrdersException(String message, int code) {
        super(message, code);
    }
}
