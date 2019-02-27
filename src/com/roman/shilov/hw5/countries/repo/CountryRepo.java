package com.roman.shilov.hw5.countries.repo;

import com.roman.shilov.hw5.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw5.countries.domain.Country;
import com.roman.shilov.hw5.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo {

    void add(Country country);

    Country findById(long id);

    List<Country> search(CountrySearchCondition searchCondition);
}
