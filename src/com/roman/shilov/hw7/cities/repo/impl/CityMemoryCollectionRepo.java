package com.roman.shilov.hw7.cities.repo.impl;

import com.roman.shilov.hw7.cities.domain.City;
import com.roman.shilov.hw7.cities.repo.CityRepo;
import com.roman.shilov.hw7.cities.search.CitySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw7.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw7.storage.Storage.cityList;

public class CityMemoryCollectionRepo implements CityRepo {
    @Override
    public void add(City city) {
        cityList.add(city);
    }

    @Override
    public City findById(long id) {
        return findCityById(id);
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByPopulation = searchCondition.getPopulation() > 0;
            boolean searchByName = isNotBlank(searchCondition.getName());

            List<City> result = new ArrayList<>();
            for (City city : cityList) {
                if (city != null) {
                    boolean found = true;
                    if (searchByPopulation) {
                        found = searchCondition.getPopulation() == city.getPopulation();
                    }

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(city.getName());
                    }

                    if (found) {
                        result.add(city);
                    }
                }
            }
            return result;
        }
    }

    @Override
    public void deleteById(long id) {
        City found = findCityById(id);

        if (found != null) {
            cityList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for(City city: cityList){
            System.out.println(city);
        }
    }

    private City findCityById(long userId) {
        for (City city : cityList) {
            if (Long.valueOf(userId).equals(city.getId())) {
                return city;
            }
        }
        return null;
    }
}
