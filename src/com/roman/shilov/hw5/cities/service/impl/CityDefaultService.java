package com.roman.shilov.hw5.cities.service.impl;

import com.roman.shilov.hw5.cities.domain.City;
import com.roman.shilov.hw5.cities.repo.CityRepo;
import com.roman.shilov.hw5.cities.service.CityService;

public class CityDefaultService implements CityService {

    private final CityRepo repo;

    public CityDefaultService(CityRepo repo) {
        this.repo = repo;
    }

    @Override
    public void add(City city) {
        repo.add(city);
    }

    @Override
    public City findById(Long id) {
        if(id != null){
            return repo.findById(id);
        }else {
            return null;
        }
    }

    @Override
    public void delete(City city) {
        if(city.getId() != null){
            this.deleteById(city.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if(id != null){
            repo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        repo.printAll();
    }
}
