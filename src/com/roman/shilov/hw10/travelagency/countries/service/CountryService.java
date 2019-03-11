package com.roman.shilov.hw10.travelagency.countries.service;

import com.roman.shilov.hw10.travelagency.common.solutions.service.BaseService;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<Country, Long> {


    List<Country> search(CountrySearchCondition searchCondition);
}
