package com.roman.shilov.hw5.countries.repo.impl;

import com.roman.shilov.hw5.common.solutions.ArrayUtils.ArrayUtils;
import com.roman.shilov.hw5.countries.domain.Country;
import com.roman.shilov.hw5.countries.repo.CountryRepo;
import com.roman.shilov.hw5.order.domain.Order;

import java.util.Arrays;

import static com.roman.shilov.hw5.storage.Storage.countries;

public class CountryDefaultRepo implements CountryRepo {
    private int countryIndex = -1;

    @Override
    public void add(Country country) {
        if(countryIndex == countries.length - 1) {
            Country[] newArrCountries = new Country[countries.length * 2];
            System.arraycopy(countries,0, newArrCountries, 0, countries.length);
            countries = newArrCountries;
        }

        countryIndex++;
        countries[countryIndex] = country;
    }

    @Override
    public Country findById(long id) {
        Integer countryIndex = findCountryIndexById(id);
        if(countryIndex != null){
            return countries[countryIndex];
        }

        return null;
    }

    @Override
    public void deleteById(long id) {
        Integer countryIndex = findCountryIndexById(id);
        if(countryIndex != null){
            deleteCountryByIndex(countryIndex);
        }
    }

    private void deleteCountryByIndex(int index){
        ArrayUtils.removeElement(countries, index);
        countryIndex--;
    }

    @Override
    public void printAll() {
        Arrays.stream(countries).forEach(System.out::println);
    }

    private Integer findCountryIndexById(Long countryId){
        for (int i = 0; i < countries.length; i++) {
            if(countries[i].getId().equals(countryId)){
                return i;
            }
        }
        return null;
    }
}
