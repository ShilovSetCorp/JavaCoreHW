package com.roman.shilov.hw11.travelagency.countries.domain;

public class Country extends BaseCountry{
    private String telephoneCode;
    private boolean polarNight;

    public String getTelephoneCode() {
        return telephoneCode;
    }

    public void setTelephoneCode(String telephoneCode) {
        this.telephoneCode = telephoneCode;
    }

    public Country(String name, String language, CountryType type, String telephoneCode, boolean polarNight) {
        super(name, language, type);
        this.telephoneCode = telephoneCode;
        this.polarNight = polarNight;
    }

    public Country() {
    }
}
