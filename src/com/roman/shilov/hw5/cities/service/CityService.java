package com.roman.shilov.hw5.cities.service;

import com.roman.shilov.hw5.cities.domain.City;
import com.roman.shilov.hw5.common.buisness.service.BaseService;

public interface CityService extends BaseService {
    void add(City city);

    City findById(Long id);

    void delete(City city);
}
