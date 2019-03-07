package com.roman.shilov.hw10.travelagency.cities.repo;

import com.roman.shilov.hw10.travelagency.cities.domain.City;
import com.roman.shilov.hw10.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw10.travelagency.common.buisness.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo {
    void add(City city);

    City findById(long id);

    List<City> search(CitySearchCondition searchCondition);

    void update(City city);
}
