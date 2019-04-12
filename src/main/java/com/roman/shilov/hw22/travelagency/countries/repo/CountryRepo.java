package com.roman.shilov.hw22.travelagency.countries.repo;

import com.roman.shilov.hw22.travelagency.common.solutions.repo.BaseRepo;
import com.roman.shilov.hw22.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw22.travelagency.countries.search.CountrySearchCondition;

import java.util.List;

public interface CountryRepo extends BaseRepo<BaseCountry, Long> {


    List<BaseCountry> search(CountrySearchCondition searchCondition);

}
