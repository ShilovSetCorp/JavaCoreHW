package com.roman.shilov.hw10.travelagency.cities.repo.impl;

import com.roman.shilov.hw10.travelagency.cities.domain.City;
import com.roman.shilov.hw10.travelagency.cities.repo.CityRepo;
import com.roman.shilov.hw10.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw10.travelagency.common.buisness.search.OrderType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.roman.shilov.hw9.travelagency.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw9.travelagency.storage.Storage.cityList;


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

            if(searchCondition.getOrderType() != null){
                if(searchCondition.getOrderType().equals(OrderType.ASC)){
                    result.sort(new Comparator<City>() {
                        @Override
                        public int compare(City o1, City o2) {
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
                    result.sort(new Comparator<City>() {
                        @Override
                        public int compare(City o1, City o2) {
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
    public void update(City city) {
        City found = findById(city.getId());
        found.setName(city.getName());
        found.setPopulation(city.getPopulation());
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
