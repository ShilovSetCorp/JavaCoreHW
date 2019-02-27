package com.roman.shilov.hw5.countries.repo.impl;

import com.roman.shilov.hw5.common.solutions.utils.ArrayUtils;
import com.roman.shilov.hw5.countries.domain.Country;
import com.roman.shilov.hw5.countries.repo.CountryRepo;
import com.roman.shilov.hw5.countries.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw5.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw5.storage.Storage.countries;

public class CountryMemoryArrayRepo implements CountryRepo {
    private static final Country[] EMPTY_COUNTRIES_ARR = new Country[0];
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
    public List<Country> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByLanguage = isNotBlank(searchCondition.getLanguage());

            boolean searchByName = isNotBlank(searchCondition.getName());

            Country[] result = new Country[countries.length];
            int resultIndex = 0;

            for (Country country : countries) {
                if (country != null) {
                    boolean found = true;

                    if (searchByLanguage) {
                        found = searchCondition.getLanguage().equals(country.getLanguage());
                    }

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(country.getName());
                    }

                    if (found) {
                        result[resultIndex] = country;
                        resultIndex++;
                    }
                }
            }

            if (resultIndex > 0) {
                Country toReturn[] = new Country[resultIndex];
                System.arraycopy(result, 0, toReturn, 0, resultIndex);
                return new ArrayList<>(Arrays.asList(toReturn));
            }
        }
        return Collections.emptyList();
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
