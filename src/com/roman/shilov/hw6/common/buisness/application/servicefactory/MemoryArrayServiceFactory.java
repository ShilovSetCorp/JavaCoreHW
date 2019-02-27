package com.roman.shilov.hw6.common.buisness.application.servicefactory;

import com.roman.shilov.hw6.cities.repo.impl.CityMemoryArrayRepo;
import com.roman.shilov.hw6.cities.service.CityService;
import com.roman.shilov.hw6.cities.service.impl.CityDefaultService;
import com.roman.shilov.hw6.countries.repo.impl.CountryMemoryArrayRepo;
import com.roman.shilov.hw6.countries.service.CountryService;
import com.roman.shilov.hw6.countries.service.impl.CountryDefaultService;
import com.roman.shilov.hw6.order.repo.impl.OrderMemoryArrayRepo;
import com.roman.shilov.hw6.order.service.OrderService;
import com.roman.shilov.hw6.order.service.impl.OrderDefaultService;
import com.roman.shilov.hw6.user.repo.impl.UserMemoryArrayRepo;
import com.roman.shilov.hw6.user.service.UserService;
import com.roman.shilov.hw6.user.service.impl.UserDefaultService;

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
