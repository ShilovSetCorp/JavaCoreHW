package com.roman.shilov.hw11.travelagency.cities.repo.impl;

import com.roman.shilov.hw11.travelagency.cities.domain.City;
import com.roman.shilov.hw11.travelagency.cities.repo.CityRepo;
import com.roman.shilov.hw11.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw11.travelagency.common.buisness.application.sequencecreator.SequenceCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw11.travelagency.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw11.travelagency.storage.Storage.cityList;


public class CityMemoryCollectionRepo implements CityRepo {

    private CityOrderingComponent orderingComponent = new CityOrderingComponent();

    @Override
    public void insert(City city) {
        city.setId(SequenceCreator.getNextId());
        cityList.add(city);
    }

    @Override
    public City findById(Long id) {
        return findCityById(id);
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {

        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<City> result = doSearch(searchCondition);
            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();

            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    private List<City> doSearch(CitySearchCondition searchCondition){

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


    @Override
    public void update(City city) {
        City found = findById(city.getId());
        found.setName(city.getName());
        found.setPopulation(city.getPopulation());
    }

    @Override
    public void deleteById(Long id) {
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
