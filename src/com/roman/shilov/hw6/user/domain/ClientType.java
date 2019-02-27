package com.roman.shilov.hw6.user.domain;

public enum ClientType {
    NEW("First time"),
    REGULAR("Usual client"),
    OLD("Last time was long time ago"),
    VIP("Very important client"),
    BAD("Bad behaviour"),
    IN_THE_BLACK_LIST("Ignore");


    private String description;

    ClientType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
