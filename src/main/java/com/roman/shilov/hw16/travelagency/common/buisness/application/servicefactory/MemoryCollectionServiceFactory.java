package com.roman.shilov.hw16.travelagency.common.buisness.application.servicefactory;

import com.roman.shilov.hw16.travelagency.cities.repo.impl.CityMemoryCollectionRepo;
import com.roman.shilov.hw16.travelagency.cities.service.CityService;
import com.roman.shilov.hw16.travelagency.cities.service.impl.CityDefaultService;
import com.roman.shilov.hw16.travelagency.countries.repo.impl.CountryMemoryCollectionRepo;
import com.roman.shilov.hw16.travelagency.countries.service.CountryService;
import com.roman.shilov.hw16.travelagency.countries.service.impl.CountryDefaultService;
import com.roman.shilov.hw16.travelagency.order.repo.impl.OrderMemoryCollectionRepo;
import com.roman.shilov.hw16.travelagency.order.service.OrderService;
import com.roman.shilov.hw16.travelagency.order.service.impl.OrderDefaultService;
import com.roman.shilov.hw16.travelagency.user.repo.impl.UserMemoryCollectionRepo;
import com.roman.shilov.hw16.travelagency.user.service.UserService;
import com.roman.shilov.hw16.travelagency.user.service.impl.UserDefaultService;

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
