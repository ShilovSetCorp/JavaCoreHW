package com.roman.shilov.hw11.travelagency.countries.domain;

import com.roman.shilov.hw11.travelagency.common.solutions.utils.Months;

public class ColdCountry extends Country {
    private Months theMostSnowingMonth;
    private int averageSnowLevel;

    public ColdCountry(String name, String language, String telephoneCode, Months theMostSnowingMonth, int averageSnowLevel) {
        super(name, language, CountryType.COLD, telephoneCode, true);
        this.theMostSnowingMonth = theMostSnowingMonth;
        this.averageSnowLevel = averageSnowLevel;
    }

    public Months getTheMostSnowingMonth() {
        return theMostSnowingMonth;
    }

    public void setTheMostSnowingMonth(Months theMostSnowingMonth) {
        this.theMostSnowingMonth = theMostSnowingMonth;
    }

    public int getAverageSnowLevel() {
        return averageSnowLevel;
    }

    public void setAverageSnowLevel(int averageSnowLevel) {
        this.averageSnowLevel = averageSnowLevel;
    }
}
