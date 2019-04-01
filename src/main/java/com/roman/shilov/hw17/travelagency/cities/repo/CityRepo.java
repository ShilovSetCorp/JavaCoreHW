package com.roman.shilov.hw17.travelagency.cities.repo;

import com.roman.shilov.hw17.travelagency.cities.domain.City;
import com.roman.shilov.hw17.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw17.travelagency.common.solutions.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {
    List<City> search(CitySearchCondition searchCondition);

}
