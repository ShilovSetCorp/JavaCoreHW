package com.roman.shilov.hw15.travelagency.countries.domain;

import com.roman.shilov.hw15.travelagency.common.solutions.utils.Months;

public class ColdCountry extends BaseCountry {
    private Months theMostSnowingMonth;
    private int averageSnowLevel;
    private boolean polarNight;


    public ColdCountry(String name, String language, String telephoneCode, Months theMostSnowingMonth, int averageSnowLevel, boolean polarNight) {
        super(name, language, CountryType.COLD, telephoneCode);
        this.theMostSnowingMonth = theMostSnowingMonth;
        this.averageSnowLevel = averageSnowLevel;
        this.polarNight = polarNight;
    }

    public ColdCountry() {
        this.setType(CountryType.COLD);
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

    public boolean isPolarNight() {
        return polarNight;
    }

    public void setPolarNight(boolean polarNight) {
        this.polarNight = polarNight;
    }
}
