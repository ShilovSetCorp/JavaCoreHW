package com.roman.shilov.hw15.travelagency.cities.search;

public enum CityOrderByField {
    NAME("cityname"), POPULATION("citypopulation");

    CityOrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
