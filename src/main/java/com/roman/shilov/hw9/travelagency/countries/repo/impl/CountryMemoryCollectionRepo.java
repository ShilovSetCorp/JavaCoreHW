package com.roman.shilov.hw9.travelagency.countries.repo.impl;

import com.roman.shilov.hw9.travelagency.cities.domain.City;
import com.roman.shilov.hw9.travelagency.common.buisness.search.SortType;
import com.roman.shilov.hw9.travelagency.countries.domain.Country;
import com.roman.shilov.hw9.travelagency.countries.repo.CountryRepo;
import com.roman.shilov.hw9.travelagency.countries.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.roman.shilov.hw9.travelagency.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw9.travelagency.storage.Storage.countryList;


public class CountryMemoryCollectionRepo implements CountryRepo {
    @Override
    public void add(Country country) {
        countryList.add(country);
    }

    @Override
    public Country findById(long id) {
        return findCountryById(id);
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByLanguage = isNotBlank(searchCondition.getLanguage());
            boolean searchByName = isNotBlank(searchCondition.getName());

            List<Country> result = new ArrayList<>();
            for (Country country : countryList) {
                if (country != null) {
                    boolean found = true;
                    if (searchByLanguage) {
                        found = searchCondition.getLanguage().equals(country.getLanguage());
                    }

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(country.getName());
                    }

                    if (found) {
                        result.add(country);
                    }
                }
            }

            if(searchCondition.getSortType() != null){
                if(searchCondition.getSortType().equals(SortType.ASC)){
                    result.sort(new Comparator<Country>() {
                        @Override
                        public int compare(Country o1, Country o2) {
                            if(o1.getId() > o2.getId()){
                                return 1;
                            }else if(o1.getId() < o2.getId()){
                                return -1;
                            }else {
                                return 0;
                            }
                        }
                    });
                }else {
                    result.sort(new Comparator<Country>() {
                        @Override
                        public int compare(Country o1, Country o2) {
                            if(o1.getId() > o2.getId()){
                                return -1;
                            }else if(o1.getId() < o2.getId()){
                                return 1;
                            }else {
                                return 0;
                            }
                        }
                    });
                }
            }

            return result;
        }
    }

    @Override
    public void update(Country country) {
        Country found = findById(country.getId());
        found.setName(country.getName());
        found.setLanguage(country.getLanguage());
        found.setCities(country.getCities());
    }

    @Override
    public void deleteById(long id) {
        Country found = findCountryById(id);

        if (found != null) {
            countryList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for(Country country: countryList){
            System.out.println(country);
        }
    }

    private Country findCountryById(long userId) {
        for (Country country : countryList) {
            if (Long.valueOf(userId).equals(country.getId())) {
                return country;
            }
        }
        return null;
    }
}
