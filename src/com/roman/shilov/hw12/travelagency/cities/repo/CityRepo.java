package com.roman.shilov.hw12.travelagency.cities.repo;

import com.roman.shilov.hw12.travelagency.cities.domain.City;
import com.roman.shilov.hw12.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw12.travelagency.common.solutions.repo.BaseRepo;

import java.util.List;

public interface CityRepo extends BaseRepo<City, Long> {
  //  void add(City city);

 //   City findById(long id);

    List<City> search(CitySearchCondition searchCondition);

 //   void update(City city);
}
