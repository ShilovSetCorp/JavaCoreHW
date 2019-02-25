package com.roman.shilov.hw5.cities.repo.impl;

import com.roman.shilov.hw5.cities.domain.City;
import com.roman.shilov.hw5.cities.repo.CityRepo;
import com.roman.shilov.hw5.common.solutions.utils.ArrayUtils;

import java.util.Arrays;

import static com.roman.shilov.hw5.storage.storage.cities;

public class CityDefaultRepo implements CityRepo {

    private int cityIndex = -1;


    @Override
    public void add(City city) {
        if(cityIndex == cities.length - 1){
            City[] newArrCities = new City[cities.length * 2];
            System.arraycopy(cities, 0, newArrCities, 0, cities.length);
            cities = newArrCities;
        }

        cityIndex++;
        cities[cityIndex] = city;
    }

    @Override
    public City findById(long id) {
        Integer cityIndex = findCityIndexId(id);
        if(cityIndex != null){
            return cities[cityIndex];
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        Integer cityIndex = findCityIndexId(id);
        if(cityIndex != null){
            deleteCityByIndex(cityIndex);
        }
    }

    private void deleteCityByIndex(int index){
        ArrayUtils.removeElement(cities, index);
        cityIndex--;
    }

    @Override
    public void printAll() {
        Arrays.stream(cities).forEach(System.out::println);
    }

    private Integer findCityIndexId(Long cityId){
        for (int i = 0; i < cities.length; i++) {
            if(cities[i].getId().equals(cityId)){
                return i;
            }
        }
        return null;
    }
}
