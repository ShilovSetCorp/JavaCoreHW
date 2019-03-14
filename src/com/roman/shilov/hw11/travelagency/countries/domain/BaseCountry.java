package com.roman.shilov.hw11.travelagency.countries.domain;

import com.roman.shilov.hw11.travelagency.cities.domain.City;
import com.roman.shilov.hw11.travelagency.common.buisness.domain.BaseDomain;


public abstract class BaseCountry extends BaseDomain {
    private String name;
    private String language;
    private City[] cities;
    private CountryType type;

    public BaseCountry(String name, String language, CountryType type) {
        this.name = name;
        this.language = language;
        this.type = type;
    }

    public CountryType getType() {
        return type;
    }

    public void setType(CountryType type) {
        this.type = type;
    }

    public BaseCountry(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public BaseCountry() {
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

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "BaseCountry{\n" +
                ", id=" + id + '\'' +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", cities=" + getCitiesAsString() +
                '}';
    }

    private String getCitiesAsString(){
        StringBuilder sb = new StringBuilder();
        for(City city : cities){
            sb.append(city.toString()).append("\n");
        }
        return sb.toString();
    }
}
