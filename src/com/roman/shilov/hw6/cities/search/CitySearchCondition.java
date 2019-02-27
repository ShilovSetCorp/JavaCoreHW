package com.roman.shilov.hw6.cities.search;

import com.roman.shilov.hw6.common.buisness.search.BaseSearchConditition;

public class CitySearchCondition extends BaseSearchConditition {
    private String name;
    private int population;

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
}
