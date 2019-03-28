package com.roman.shilov.hw16.travelagency.cities.repo;

import com.roman.shilov.hw16.travelagency.cities.domain.City;
import com.roman.shilov.hw16.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw16.travelagency.common.solutions.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {
    List<City> search(CitySearchCondition searchCondition);

}
