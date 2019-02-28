package com.roman.shilov.hw7.cities.repo;

import com.roman.shilov.hw7.cities.domain.City;
import com.roman.shilov.hw7.cities.search.CitySearchCondition;
import com.roman.shilov.hw7.common.buisness.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo {
    void add(City city);

    City findById(long id);

    List<City> search(CitySearchCondition searchCondition);
}
