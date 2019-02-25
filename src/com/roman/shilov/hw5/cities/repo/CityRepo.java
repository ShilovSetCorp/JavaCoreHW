package com.roman.shilov.hw5.cities.repo;

import com.roman.shilov.hw5.cities.domain.City;
import com.roman.shilov.hw5.common.buisness.repo.BaseRepo;

public interface CityRepo extends BaseRepo {
    void add(City city);

    City findById(long id);
}
