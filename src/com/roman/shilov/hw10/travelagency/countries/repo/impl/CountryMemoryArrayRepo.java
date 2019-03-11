package com.roman.shilov.hw10.travelagency.countries.repo.impl;


import com.roman.shilov.hw10.travelagency.common.buisness.application.sequencecreator.SequenceCreator;
import com.roman.shilov.hw10.travelagency.common.buisness.search.OrderType;
import com.roman.shilov.hw10.travelagency.common.solutions.utils.ArrayUtils;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.countries.repo.CountryRepo;
import com.roman.shilov.hw10.travelagency.countries.search.CountrySearchCondition;

import java.util.*;

import static com.roman.shilov.hw10.travelagency.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw10.travelagency.storage.Storage.countries;


public class CountryMemoryArrayRepo implements CountryRepo {
    private static final Country[] EMPTY_COUNTRIES_ARR = new Country[0];
    private CountryOrderingComponent orderingComponent = new CountryOrderingComponent();
    private int countryIndex = -1;

    @Override
    public void insert(Country country) {
        if(countryIndex == countries.length - 1) {
            Country[] newArrCountries = new Country[countries.length * 2];
            System.arraycopy(countries,0, newArrCountries, 0, countries.length);
            countries = newArrCountries;
        }

        country.setId(SequenceCreator.getNextId());
        countryIndex++;
        countries[countryIndex] = country;
    }

    @Override
    public Country findById(Long id) {
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
            List<Country> result = doSearch(searchCondition);
            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();

            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    private List<Country> doSearch(CountrySearchCondition searchCondition){
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
        return Collections.emptyList();
    }

    @Override
    public void update(Country country) {
        Country found = findById(country.getId());
        found.setName(country.getName());
        found.setLanguage(country.getLanguage());
        found.setCities(country.getCities());
    }

    @Override
    public void deleteById(Long id) {
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
