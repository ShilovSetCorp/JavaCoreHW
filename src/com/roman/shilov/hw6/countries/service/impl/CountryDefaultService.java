package com.roman.shilov.hw6.countries.service.impl;

import com.roman.shilov.hw6.cities.domain.City;
import com.roman.shilov.hw6.cities.repo.CityRepo;
import com.roman.shilov.hw6.countries.domain.Country;
import com.roman.shilov.hw6.countries.repo.CountryRepo;
import com.roman.shilov.hw6.countries.search.CountrySearchCondition;
import com.roman.shilov.hw6.countries.service.CountryService;

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
    public void add(Country country) {
        countryRepo.add(country);

        if(country.getCities() != null){
            for(City city : country.getCities()){
                cityRepo.add(city);
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
