package com.roman.shilov.hw11.travelagency.cities.domain;

import com.roman.shilov.hw11.travelagency.common.buisness.domain.BaseDomain;


public class City extends BaseDomain {
    private String name;
    private int population;
    private boolean isCapital;

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

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", isCapital=" + isCapital +
                ", id=" + id +
                '}';
    }
}
