package com.roman.shilov.hw11.travelagency.common.buisness.application.servicefactory;

import com.roman.shilov.hw11.travelagency.cities.repo.impl.CityMemoryArrayRepo;
import com.roman.shilov.hw11.travelagency.cities.service.CityService;
import com.roman.shilov.hw11.travelagency.cities.service.impl.CityDefaultService;
import com.roman.shilov.hw11.travelagency.countries.repo.impl.CountryMemoryArrayRepo;
import com.roman.shilov.hw11.travelagency.countries.service.CountryService;
import com.roman.shilov.hw11.travelagency.countries.service.impl.CountryDefaultService;
import com.roman.shilov.hw11.travelagency.order.repo.impl.OrderMemoryArrayRepo;
import com.roman.shilov.hw11.travelagency.order.service.OrderService;
import com.roman.shilov.hw11.travelagency.order.service.impl.OrderDefaultService;
import com.roman.shilov.hw11.travelagency.user.repo.impl.UserMemoryArrayRepo;
import com.roman.shilov.hw11.travelagency.user.service.UserService;
import com.roman.shilov.hw11.travelagency.user.service.impl.UserDefaultService;

public class MemoryArrayServiceFactory implements ServiceFactory {
    @Override
    public UserService getUserService() {
        return new UserDefaultService(new UserMemoryArrayRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderDefaultService(new OrderMemoryArrayRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryDefaultService(new CountryMemoryArrayRepo(), new CityMemoryArrayRepo());
    }

    @Override
    public CityService getCityService() {
        return new CityDefaultService(new CityMemoryArrayRepo());
    }
}
