package com.roman.shilov.hw12.travelagency.cities.search;

import com.roman.shilov.hw12.travelagency.common.buisness.search.BaseSearchConditition;

import static com.roman.shilov.hw11.travelagency.common.solutions.utils.StringUtils.isNotBlank;

public class CitySearchCondition extends BaseSearchConditition {
    private String name;
    private int population;
    private CityOrderByField orderByField;

    public CityOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(CityOrderByField orderByField) {
        this.orderByField = orderByField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean needOrdering() {
        return super.needOrdering() && orderByField != null;
    }

    public boolean searchByName(){
        return isNotBlank(this.getName());
    }

    public boolean searchByPopulation(){
        return this.getPopulation() > 0;
    }
}
