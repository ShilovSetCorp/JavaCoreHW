package com.roman.shilov.hw16.travelagency.countries.search;

import com.roman.shilov.hw16.travelagency.common.solutions.utils.Months;

public class ColdCountrySearchCondition extends CountrySearchCondition {
    private Months theMostSnowingMonth;
    private int averageSnowLevel;

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
