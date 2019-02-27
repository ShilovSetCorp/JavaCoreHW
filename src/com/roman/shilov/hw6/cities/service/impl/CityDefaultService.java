package com.roman.shilov.hw6.cities.service.impl;

import com.roman.shilov.hw6.cities.domain.City;
import com.roman.shilov.hw6.cities.repo.CityRepo;
import com.roman.shilov.hw6.cities.search.CitySearchCondition;
import com.roman.shilov.hw6.cities.service.CityService;

import java.util.List;

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
    public List<City> search(CitySearchCondition searchCondition) {
        return repo.search(searchCondition);
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
