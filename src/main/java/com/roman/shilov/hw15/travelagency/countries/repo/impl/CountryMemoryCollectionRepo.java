package com.roman.shilov.hw15.travelagency.countries.repo.impl;

import com.roman.shilov.hw15.travelagency.common.buisness.application.sequencecreator.SequenceCreator;
import com.roman.shilov.hw15.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw15.travelagency.countries.repo.CountryRepo;
import com.roman.shilov.hw15.travelagency.countries.search.CountrySearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw15.travelagency.common.solutions.utils.StringUtils.isNotBlank;
import static com.roman.shilov.hw15.travelagency.storage.Storage.baseCountryList;


public class CountryMemoryCollectionRepo implements CountryRepo {
    private CountryOrderingComponent orderingComponent = new CountryOrderingComponent();

    @Override
    public void insert(BaseCountry baseCountry) {
        baseCountry.setId(SequenceCreator.getNextId());
        baseCountryList.add(baseCountry);
    }

    @Override
    public BaseCountry findById(Long id) {
        return findCountryById(id);
    }

    @Override
    public List<BaseCountry> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<BaseCountry> result = doSearch(searchCondition);
            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();

            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    private List<BaseCountry> doSearch(CountrySearchCondition searchCondition){

        boolean searchByLanguage = isNotBlank(searchCondition.getLanguage());
        boolean searchByName = isNotBlank(searchCondition.getName());

        List<BaseCountry> result = new ArrayList<>();
        for (BaseCountry baseCountry : baseCountryList) {
            if (baseCountry != null) {
                boolean found = true;
                if (searchByLanguage) {
                    found = searchCondition.getLanguage().equals(baseCountry.getLanguage());
                }

                if (found && searchByName) {
                    found = searchCondition.getName().equals(baseCountry.getName());
                }

                if (found) {
                    result.add(baseCountry);
                }
            }
        }

        return result;
    }

    @Override
    public void update(BaseCountry baseCountry) {
        BaseCountry found = findById(baseCountry.getId());
        found.setName(baseCountry.getName());
        found.setLanguage(baseCountry.getLanguage());
        found.setCities(baseCountry.getCities());
    }

    @Override
    public void deleteById(Long id) {
        BaseCountry found = findCountryById(id);

        if (found != null) {
            baseCountryList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for(BaseCountry baseCountry : baseCountryList){
            System.out.println(baseCountry);
        }
    }

    private BaseCountry findCountryById(long userId) {
        for (BaseCountry baseCountry : baseCountryList) {
            if (Long.valueOf(userId).equals(baseCountry.getId())) {
                return baseCountry;
            }
        }
        return null;
    }
}
