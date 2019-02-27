package com.roman.shilov.hw6.common.buisness.application.servicefactory;

import com.roman.shilov.hw6.cities.service.CityService;
import com.roman.shilov.hw6.countries.service.CountryService;
import com.roman.shilov.hw6.order.service.OrderService;
import com.roman.shilov.hw6.user.service.UserService;

public interface ServiceFactory {
    UserService getUserService();
    OrderService getOrderService();
    CountryService getCountryService();
    CityService getCityService();
}
