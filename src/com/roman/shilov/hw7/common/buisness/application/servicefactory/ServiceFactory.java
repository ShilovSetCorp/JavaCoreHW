package com.roman.shilov.hw7.common.buisness.application.servicefactory;

import com.roman.shilov.hw7.cities.service.CityService;
import com.roman.shilov.hw7.countries.service.CountryService;
import com.roman.shilov.hw7.order.service.OrderService;
import com.roman.shilov.hw7.user.service.UserService;

public interface ServiceFactory {
    UserService getUserService();
    OrderService getOrderService();
    CountryService getCountryService();
    CityService getCityService();
}
