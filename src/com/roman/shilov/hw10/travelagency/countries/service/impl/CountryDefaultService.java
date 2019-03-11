package com.roman.shilov.hw10.travelagency.countries.service.impl;

import com.roman.shilov.hw10.travelagency.cities.domain.City;
import com.roman.shilov.hw10.travelagency.cities.repo.CityRepo;
import com.roman.shilov.hw10.travelagency.common.buisness.application.sequencecreator.SequenceCreator;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.countries.repo.CountryRepo;
import com.roman.shilov.hw10.travelagency.countries.search.CountrySearchCondition;
import com.roman.shilov.hw10.travelagency.countries.service.CountryService;

import java.util.List;

public class CountryDefaultService implements CountryService {
    private final CountryRepo countryRepo;
    private final CityRepo cityRepo;

    public CountryDefaultService(CountryRepo countryRepo, CityRepo cityRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo = cityRepo;
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return countryRepo.search(searchCondition);
    }

    @Override
    public void insert(Country country) {
        country.setId(SequenceCreator.getNextId());
        countryRepo.insert(country);

        if(country.getCities() != null){
            for(City city : country.getCities()){
                city.setId(SequenceCreator.getNextId());
                cityRepo.insert(city);
            }
        }
    }

    @Override
    public Country findById(Long id) {
        if(id != null){
            return countryRepo.findById(id);
        }else {
            return null;
        }
    }

    @Override
    public void update(Country country) {
        countryRepo.update(country);
    }

    @Override
    public void delete(Country country) {
        if(country.getId() != null){
            this.deleteById(country.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if(id != null){
            countryRepo.deleteById(id);
        }
    }



    @Override
    public void printAll() {
        countryRepo.printAll();
    }
}
