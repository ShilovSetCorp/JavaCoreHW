package com.roman.shilov.hw10.travelagency.countries.repo.impl;

import com.roman.shilov.hw10.travelagency.countries.search.CountryOrderByField;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;

import static com.roman.shilov.hw10.travelagency.countries.search.CountryOrderByField.NAME;
import static com.roman.shilov.hw10.travelagency.countries.search.CountryOrderByField.LANGUAGE;
import static com.roman.shilov.hw10.travelagency.common.buisness.repo.memory.CommonComparatorHolder.getComparatorForNullableStrings;
import static com.roman.shilov.hw10.travelagency.common.buisness.repo.memory.CommonComparatorHolder.getIntegerComparator;

import java.util.*;

public class CountryComparatorComponent {

    private static final CountryComparatorComponent INSTANCE = new CountryComparatorComponent();
    private static Map<CountryOrderByField, Comparator<Country>> comparatorsByField = new HashMap<>();

    private static Set<CountryOrderByField> fieldComparePriorityOrder = new LinkedHashSet<>(Arrays.asList(NAME, LANGUAGE));

    static {
        comparatorsByField.put(NAME, getComparatorForNameField());
        comparatorsByField.put(LANGUAGE, getComparatorForLanguageField());
    }

    public CountryComparatorComponent() {
    }

    public static CountryComparatorComponent getInstance(){
        return INSTANCE;
    }

    private static Comparator<Country> getComparatorForNameField() {
        return new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return getComparatorForNullableStrings().compare(o1.getName(), o2.getName());
            }
        };
    }

    private static Comparator<Country> getComparatorForLanguageField(){
        return new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return getComparatorForNullableStrings().compare(o1.getLanguage(), o2.getLanguage());
            }
        };
    }

    public Comparator<Country> getComparatorForField(CountryOrderByField field){
        return comparatorsByField.get(field);
    }

    public Comparator<Country> getComplexComparator(CountryOrderByField field){
        return new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                int result = 0;
                Comparator<Country> countryComparator = comparatorsByField.get(field);

                if(countryComparator != null){
                    result = countryComparator.compare(o1, o2);

                    if(result == 0){

                        for(CountryOrderByField otherField : fieldComparePriorityOrder){
                            if(!otherField.equals(field)){

                                result = comparatorsByField.get(otherField).compare(o1, o2);
                            }
                        }
                    }
                }

                return result;
            }
        };
    }
}
