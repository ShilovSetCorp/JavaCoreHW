package com.roman.shilov.hw12.travelagency.countries.domain;

import com.roman.shilov.hw12.travelagency.common.solutions.utils.Months;


public class HotCountry extends BaseCountry {
    private Months hottestMonth;
    private int averageTemp;

    public HotCountry(String name, String language, String telephoneCode, Months hottestMonth, int averageTemp) {
        super(name, language, CountryType.HOT, telephoneCode);
        this.hottestMonth = hottestMonth;
        this.averageTemp = averageTemp;
    }

    public HotCountry() {
        this.setType(CountryType.HOT);
    }

    public Months getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(Months hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public int getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(int averageTemp) {
        this.averageTemp = averageTemp;
    }
}
