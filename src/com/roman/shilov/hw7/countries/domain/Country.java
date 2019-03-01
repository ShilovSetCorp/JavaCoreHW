package com.roman.shilov.hw7.countries.domain;

import com.roman.shilov.hw7.cities.domain.City;
import com.roman.shilov.hw7.common.buisness.domain.BaseDomain;


public abstract class Country extends BaseDomain {
    private String name;
    private String language;
    private City[] cities;

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public Country() {
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
        return "Country{\n" +
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
