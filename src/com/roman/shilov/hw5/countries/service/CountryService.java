package com.roman.shilov.hw5.countries.service;

import com.roman.shilov.hw5.common.buisness.service.BaseService;
import com.roman.shilov.hw5.countries.domain.Country;
import com.roman.shilov.hw5.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService {
    void add(Country country);

    Country findById(Long id);

    void delete(Country country);

    List<Country> search(CountrySearchCondition searchCondition);
}
