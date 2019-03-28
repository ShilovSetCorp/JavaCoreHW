package com.roman.shilov.hw16.travelagency.countries.service;

import com.roman.shilov.hw16.travelagency.common.solutions.service.BaseService;
import com.roman.shilov.hw16.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw16.travelagency.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService<BaseCountry, Long> {


    List<BaseCountry> search(CountrySearchCondition searchCondition);
}
