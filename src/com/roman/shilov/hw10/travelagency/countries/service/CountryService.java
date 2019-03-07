package com.roman.shilov.hw10.travelagency.countries.service;

import com.roman.shilov.hw10.travelagency.common.buisness.service.BaseService;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService {
    void add(Country country);

    Country findById(Long id);

    void update(Country country);

    void delete(Country country);

    List<Country> search(CountrySearchCondition searchCondition);
}
