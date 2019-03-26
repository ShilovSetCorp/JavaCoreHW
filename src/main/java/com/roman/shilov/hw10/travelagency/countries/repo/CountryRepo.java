package com.roman.shilov.hw10.travelagency.countries.repo;

import com.roman.shilov.hw10.travelagency.common.solutions.repo.BaseRepo;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<Country, Long> {


    List<Country> search(CountrySearchCondition searchCondition);

}
