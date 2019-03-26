package com.roman.shilov.hw10.travelagency.cities.service;

import com.roman.shilov.hw10.travelagency.cities.domain.City;
import com.roman.shilov.hw10.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw10.travelagency.common.solutions.service.BaseService;

import java.util.List;

public interface CityService extends BaseService<City, Long> {

    List<City> search(CitySearchCondition searchCondition);
}
