package com.roman.shilov.hw11.travelagency.countries.repo.impl;


import com.roman.shilov.hw11.travelagency.common.buisness.application.sequencecreator.SequenceCreator;
import com.roman.shilov.hw11.travelagency.common.solutions.utils.ArrayUtils;
import com.roman.shilov.hw11.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw11.travelagency.countries.repo.CountryRepo;
import com.roman.shilov.hw11.travelagency.countries.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw11.travelagency.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw11.travelagency.storage.Storage.countries;


public class CountryMemoryArrayRepo implements CountryRepo {
    private static final BaseCountry[] EMPTY_COUNTRIES_ARR = new BaseCountry[0];
    private CountryOrderingComponent orderingComponent = new CountryOrderingComponent();
    private int countryIndex = -1;

    @Override
    public void insert(BaseCountry baseCountry) {
        if(countryIndex == countries.length - 1) {
            BaseCountry[] newArrCountries = new BaseCountry[countries.length * 2];
            System.arraycopy(countries,0, newArrCountries, 0, countries.length);
            countries = newArrCountries;
        }

        baseCountry.setId(SequenceCreator.getNextId());
        countryIndex++;
        countries[countryIndex] = baseCountry;
    }

    @Override
    public BaseCountry findById(Long id) {
        Integer countryIndex = findCountryIndexById(id);
        if(countryIndex != null){
            return countries[countryIndex];
        }

        return null;
    }

    @Override
    public List<BaseCountry> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<BaseCountry> result = doSearch(searchCondition);
            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();

            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    private List<BaseCountry> doSearch(CountrySearchCondition searchCondition){
        boolean searchByLanguage = isNotBlank(searchCondition.getLanguage());

        boolean searchByName = isNotBlank(searchCondition.getName());

        BaseCountry[] result = new BaseCountry[countries.length];
        int resultIndex = 0;

        for (BaseCountry baseCountry : countries) {
            if (baseCountry != null) {
                boolean found = true;

                if (searchByLanguage) {
                    found = searchCondition.getLanguage().equals(baseCountry.getLanguage());
                }

                if (found && searchByName) {
                    found = searchCondition.getName().equals(baseCountry.getName());
                }

                if (found) {
                    result[resultIndex] = baseCountry;
                    resultIndex++;
                }
            }
        }

        if (resultIndex > 0) {
            BaseCountry toReturn[] = new BaseCountry[resultIndex];
            System.arraycopy(result, 0, toReturn, 0, resultIndex);
            return new ArrayList<>(Arrays.asList(toReturn));
        }
        return Collections.emptyList();
    }

    @Override
    public void update(BaseCountry baseCountry) {
        BaseCountry found = findById(baseCountry.getId());
        found.setName(baseCountry.getName());
        found.setLanguage(baseCountry.getLanguage());
        found.setCities(baseCountry.getCities());
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
