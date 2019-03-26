package com.roman.shilov.hw12.travelagency.common.buisness.application.servicefactory;

import com.roman.shilov.hw12.travelagency.cities.service.CityService;
import com.roman.shilov.hw12.travelagency.countries.service.CountryService;
import com.roman.shilov.hw12.travelagency.order.service.OrderService;
import com.roman.shilov.hw12.travelagency.user.service.UserService;

public interface ServiceFactory {
    UserService getUserService();
    OrderService getOrderService();
    CountryService getCountryService();
    CityService getCityService();
}
