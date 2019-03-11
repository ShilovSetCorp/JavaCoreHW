package com.roman.shilov.hw10.travelagency.cities.service.impl;

import com.roman.shilov.hw10.travelagency.cities.domain.City;
import com.roman.shilov.hw10.travelagency.cities.repo.CityRepo;
import com.roman.shilov.hw10.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw10.travelagency.cities.service.CityService;
import com.roman.shilov.hw10.travelagency.common.buisness.application.sequencecreator.SequenceCreator;

import java.util.List;

public class CityDefaultService implements CityService {

    private final CityRepo repo;

    public CityDefaultService(CityRepo repo) {
        this.repo = repo;
    }

    @Override
    public void insert(City city) {
        if(city != null)
            repo.insert(city);
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
    public void update(City city) {
        repo.update(city);
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
