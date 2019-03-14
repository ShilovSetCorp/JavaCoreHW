package com.roman.shilov.hw11.travelagency.countries.domain;

import com.roman.shilov.hw11.travelagency.common.solutions.utils.*;

public class HotCountry extends Country {
    private Months hottestMonth;
    private int averageTemp;

    public HotCountry(String name, String language, String telephoneCode, Months hottestMonth, int averageTemp) {
        super(name, language, CountryType.HOT, telephoneCode, false);
        this.hottestMonth = hottestMonth;
        this.averageTemp = averageTemp;
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
