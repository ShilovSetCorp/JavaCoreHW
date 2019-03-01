package com.roman.shilov.hw7.cities.service;

import com.roman.shilov.hw7.cities.domain.City;
import com.roman.shilov.hw7.cities.search.CitySearchCondition;
import com.roman.shilov.hw7.common.buisness.service.BaseService;

import java.util.List;

public interface CityService extends BaseService {
    void add(City city);

    City findById(Long id);

    void update(City city);

    void delete(City city);

    List<City> search(CitySearchCondition searchCondition);
}
