package com.roman.shilov.hw5.common.buisness.application.servicefactory;

import com.roman.shilov.hw5.cities.service.CityService;
import com.roman.shilov.hw5.countries.service.CountryService;
import com.roman.shilov.hw5.order.service.OrderService;
import com.roman.shilov.hw5.user.service.UserService;

public interface ServiceFactory {
    UserService getUserService();
    OrderService getOrderService();
    CountryService getCountryService();
    CityService getCityService();
}
