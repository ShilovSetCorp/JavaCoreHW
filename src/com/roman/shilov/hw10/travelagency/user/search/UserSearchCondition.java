package com.roman.shilov.hw10.travelagency.user.search;

import com.roman.shilov.hw10.travelagency.common.buisness.search.BaseSearchConditition;

public class UserSearchCondition extends BaseSearchConditition {

    private String name;
    private String last;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
