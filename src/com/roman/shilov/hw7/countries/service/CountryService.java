package com.roman.shilov.hw7.countries.service;

import com.roman.shilov.hw7.common.buisness.service.BaseService;
import com.roman.shilov.hw7.countries.domain.Country;
import com.roman.shilov.hw7.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService {
    void add(Country country);

    Country findById(Long id);

    void delete(Country country);

    List<Country> search(CountrySearchCondition searchCondition);
}
