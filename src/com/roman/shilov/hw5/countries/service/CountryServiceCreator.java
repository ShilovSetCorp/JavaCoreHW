package com.roman.shilov.hw5.countries.service;

import com.roman.shilov.hw5.cities.repo.impl.CityMemoryArrayRepo;
import com.roman.shilov.hw5.cities.repo.impl.CityMemoryCollectionRepo;
import com.roman.shilov.hw5.common.buisness.application.StorageType;
import com.roman.shilov.hw5.countries.repo.impl.CountryMemoryArrayRepo;
import com.roman.shilov.hw5.countries.repo.impl.CountryMemoryCollectionRepo;
import com.roman.shilov.hw5.countries.service.impl.CountryDefaultService;

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
