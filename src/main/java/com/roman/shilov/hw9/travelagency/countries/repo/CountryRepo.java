package com.roman.shilov.hw9.travelagency.countries.repo;

import com.roman.shilov.hw9.travelagency.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw9.travelagency.countries.domain.Country;
import com.roman.shilov.hw9.travelagency.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo {

    void add(Country country);

    Country findById(long id);

    List<Country> search(CountrySearchCondition searchCondition);

    void update(Country country);
}
