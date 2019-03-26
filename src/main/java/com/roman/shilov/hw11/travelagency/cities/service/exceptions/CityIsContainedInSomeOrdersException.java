package com.roman.shilov.hw11.travelagency.cities.service.exceptions;

import com.roman.shilov.hw11.travelagency.common.buisness.exceptions.BasicTravelCheckedException;

public class CityIsContainedInSomeOrdersException extends BasicTravelCheckedException {
    public CityIsContainedInSomeOrdersException(String message, int code) {
        super(message, code);
    }
}
