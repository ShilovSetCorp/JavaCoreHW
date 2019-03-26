package com.roman.shilov.hw12.travelagency.countries.repo.impl;


import com.roman.shilov.hw12.travelagency.common.buisness.application.sequencecreator.SequenceCreator;
import com.roman.shilov.hw12.travelagency.common.solutions.utils.ArrayUtils;
import com.roman.shilov.hw12.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw12.travelagency.countries.domain.ColdCountry;
import com.roman.shilov.hw12.travelagency.countries.domain.HotCountry;
import com.roman.shilov.hw12.travelagency.countries.repo.CountryRepo;
import com.roman.shilov.hw12.travelagency.countries.search.ColdCountrySearchCondition;
import com.roman.shilov.hw12.travelagency.countries.search.CountrySearchCondition;
import com.roman.shilov.hw12.travelagency.countries.search.HotCountrySearchCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw12.travelagency.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw12.travelagency.storage.Storage.countries;


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
        boolean searchByPhoneCode = isNotBlank(searchCondition.getPhoneCode());

        boolean searchByAverageTemperature = false;
        boolean searchByAverageSnowLevel = false;
        if(searchCondition instanceof HotCountrySearchCondition){
            searchByAverageTemperature = ((HotCountrySearchCondition) searchCondition).getAverageTemp() > 0;
        }else if(searchCondition instanceof ColdCountrySearchCondition){
            searchByAverageSnowLevel = ((ColdCountrySearchCondition) searchCondition).getAverageSnowLevel() > 0;
        }

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

                if (found && searchByPhoneCode){
                    found = searchCondition.getPhoneCode().equals((baseCountry).getTelephoneCode());
                }

                if(found && searchByAverageTemperature &&(baseCountry instanceof HotCountry)){
                    found = ((HotCountrySearchCondition)searchCondition).getAverageTemp() == ((HotCountry)baseCountry).getAverageTemp();
                }

                if(found && searchByAverageSnowLevel && (baseCountry instanceof ColdCountry)){
                    found = ((ColdCountrySearchCondition)searchCondition).getAverageSnowLevel() == ((ColdCountry)baseCountry).getAverageSnowLevel();
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
