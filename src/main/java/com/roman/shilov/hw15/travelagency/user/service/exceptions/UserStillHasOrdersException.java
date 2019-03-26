package com.roman.shilov.hw15.travelagency.user.service.exceptions;

import com.roman.shilov.hw15.travelagency.common.buisness.exceptions.BasicTravelCheckedException;

public class UserStillHasOrdersException extends BasicTravelCheckedException {

    public UserStillHasOrdersException(String message, int code) {
        super(message, code);
    }
}
