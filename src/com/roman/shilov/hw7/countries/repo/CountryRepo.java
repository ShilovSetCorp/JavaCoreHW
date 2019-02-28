package com.roman.shilov.hw7.countries.repo;

import com.roman.shilov.hw7.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw7.countries.domain.Country;
import com.roman.shilov.hw7.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo {

    void add(Country country);

    Country findById(long id);

    List<Country> search(CountrySearchCondition searchCondition);
}
