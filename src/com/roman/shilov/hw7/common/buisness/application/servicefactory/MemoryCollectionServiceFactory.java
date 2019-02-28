package com.roman.shilov.hw7.common.buisness.application.servicefactory;

import com.roman.shilov.hw7.cities.repo.impl.CityMemoryCollectionRepo;
import com.roman.shilov.hw7.cities.service.CityService;
import com.roman.shilov.hw7.cities.service.impl.CityDefaultService;
import com.roman.shilov.hw7.countries.repo.impl.CountryMemoryCollectionRepo;
import com.roman.shilov.hw7.countries.service.CountryService;
import com.roman.shilov.hw7.countries.service.impl.CountryDefaultService;
import com.roman.shilov.hw7.order.repo.impl.OrderMemoryCollectionRepo;
import com.roman.shilov.hw7.order.service.OrderService;
import com.roman.shilov.hw7.order.service.impl.OrderDefaultService;
import com.roman.shilov.hw7.user.repo.impl.UserMemoryCollectionRepo;
import com.roman.shilov.hw7.user.service.UserService;
import com.roman.shilov.hw7.user.service.impl.UserDefaultService;

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
