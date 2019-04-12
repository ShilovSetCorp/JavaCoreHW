package com.roman.shilov.hw22.travelagency.common.buisness.application.servicefactory;

import com.roman.shilov.hw22.travelagency.cities.repo.impl.memory.CityMemoryCollectionRepo;
import com.roman.shilov.hw22.travelagency.cities.service.CityService;
import com.roman.shilov.hw22.travelagency.cities.service.impl.CityDefaultService;
import com.roman.shilov.hw22.travelagency.countries.repo.impl.memory.CountryMemoryCollectionRepo;
import com.roman.shilov.hw22.travelagency.countries.service.CountryService;
import com.roman.shilov.hw22.travelagency.countries.service.impl.CountryDefaultService;
import com.roman.shilov.hw22.travelagency.order.repo.impl.memory.OrderMemoryCollectionRepo;
import com.roman.shilov.hw22.travelagency.order.service.OrderService;
import com.roman.shilov.hw22.travelagency.order.service.impl.OrderDefaultService;
import com.roman.shilov.hw22.travelagency.user.repo.impl.memory.UserMemoryCollectionRepo;
import com.roman.shilov.hw22.travelagency.user.service.UserService;
import com.roman.shilov.hw22.travelagency.user.service.impl.UserDefaultService;

public class MemoryCollectionServiceFactory implements ServiceFactory {
    @Override
    public UserService getUserService() {
        return new UserDefaultService(new UserMemoryCollectionRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderDefaultService(new OrderMemoryCollectionRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryDefaultService(new CountryMemoryCollectionRepo(), new CityMemoryCollectionRepo());
    }

    @Override
    public CityService getCityService() {
        return new CityDefaultService(new CityMemoryCollectionRepo());
    }
}
