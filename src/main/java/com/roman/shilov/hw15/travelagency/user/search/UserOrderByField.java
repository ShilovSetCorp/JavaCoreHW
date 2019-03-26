package com.roman.shilov.hw15.travelagency.user.search;

public enum UserOrderByField {
    NAME("username"), LAST("lastname");

    private String description;

    UserOrderByField(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
