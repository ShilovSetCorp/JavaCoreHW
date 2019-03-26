package com.roman.shilov.hw15.travelagency.user.domain;

import java.util.HashMap;
import java.util.Map;

public enum ClientType {
    NEW("First time"),
    REGULAR("Usual client"),
    OLD("Last time was long time ago"),
    VIP("Very important client"),
    BAD("Bad behaviour"),
    IN_THE_BLACK_LIST("Ignore");

    private Map<String, ClientType> map = new HashMap<>();


    /**
     * @param  str
     * @return boolean if String contains in Enum ClientTypes
     */
    public boolean containsInEnum(String str){
        if(!map.isEmpty()){
            return map.containsKey(str);
        }
        return false;
    }

    private String description;

    ClientType(String description){
        this.description = description;
        map.put(this.name(), this);
    }

    public String getDescription() {
        return description;
    }
}
