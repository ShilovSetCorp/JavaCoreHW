package com.roman.shilov.hw10.travelagency.countries.search;

import com.roman.shilov.hw10.travelagency.common.buisness.search.BaseSearchConditition;

public class CountrySearchCondition extends BaseSearchConditition {
    private String name;
    private String language;
    private CountryOrderByField orderByField;

    public CountryOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(CountryOrderByField orderByField) {
        this.orderByField = orderByField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean needOrdering(){
        return super.needOrdering() && orderByField != null;
    }
}
