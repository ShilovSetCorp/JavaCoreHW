package com.roman.shilov.hw22.travelagency.countries.service;

import com.roman.shilov.hw22.travelagency.cities.repo.impl.memory.CityMemoryArrayRepo;
import com.roman.shilov.hw22.travelagency.cities.repo.impl.memory.CityMemoryCollectionRepo;
import com.roman.shilov.hw22.travelagency.common.buisness.application.StorageType;
import com.roman.shilov.hw22.travelagency.countries.repo.impl.memory.CountryMemoryArrayRepo;
import com.roman.shilov.hw22.travelagency.countries.repo.impl.memory.CountryMemoryCollectionRepo;
import com.roman.shilov.hw22.travelagency.countries.service.impl.CountryDefaultService;

public final class CountryServiceCreator {
    private CountryServiceCreator() {
    }

    public static CountryService getCityService(StorageType storageType){
        switch (storageType){

            case MEMORY_ARRAY:
                return new CountryDefaultService(new CountryMemoryArrayRepo(), new CityMemoryArrayRepo());

            case MEMORY_COLLECTION:
                return new CountryDefaultService(new CountryMemoryCollectionRepo(), new CityMemoryCollectionRepo());

            default: return null;
        }
    }
}
