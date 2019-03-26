package com.roman.shilov.hw10.travelagency.countries.repo.impl;

import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.countries.search.CountryOrderByField;
import com.roman.shilov.hw10.travelagency.countries.search.CountrySearchCondition;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryOrderingComponent {

    public void applyOrdering(List<Country> countries, CountrySearchCondition searchCondition) {
        Comparator<Country> countryComparator = null;

        CountryOrderByField field = searchCondition.getOrderByField();

        switch (searchCondition.getOrderType()) {

            case SIMPLE: {
                countryComparator = CountryComparatorComponent.getInstance().getComparatorForField(field);
                break;
            }

            case COMPLEX: {
                countryComparator = CountryComparatorComponent.getInstance().getComplexComparator(field);
                break;
            }
        }

        if(countryComparator != null) {
            switch (searchCondition.getOrderDirection()){
                case ASC:
                    Collections.sort(countries, countryComparator);
                    break;

                case DESC:
                    Collections.sort(countries, countryComparator.reversed());
                    break;
            }
        }
    }
}
