package com.roman.shilov.hw6.cities.repo;

import com.roman.shilov.hw6.cities.domain.City;
import com.roman.shilov.hw6.cities.search.CitySearchCondition;
import com.roman.shilov.hw6.common.buisness.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo {
    void add(City city);

    City findById(long id);

    List<City> search(CitySearchCondition searchCondition);
}
