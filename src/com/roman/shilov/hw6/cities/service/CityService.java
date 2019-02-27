package com.roman.shilov.hw6.cities.service;

import com.roman.shilov.hw6.cities.domain.City;
import com.roman.shilov.hw6.cities.search.CitySearchCondition;
import com.roman.shilov.hw6.common.buisness.service.BaseService;

import java.util.List;

public interface CityService extends BaseService {
    void add(City city);

    City findById(Long id);

    void delete(City city);

    List<City> search(CitySearchCondition searchCondition);
}
