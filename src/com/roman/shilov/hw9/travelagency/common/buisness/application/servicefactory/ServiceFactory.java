package com.roman.shilov.hw9.travelagency.common.buisness.application.servicefactory;

import com.roman.shilov.hw9.travelagency.cities.service.CityService;
import com.roman.shilov.hw9.travelagency.countries.service.CountryService;
import com.roman.shilov.hw9.travelagency.order.service.OrderService;
import com.roman.shilov.hw9.travelagency.user.service.UserService;

public interface ServiceFactory {
    UserService getUserService();
    OrderService getOrderService();
    CountryService getCountryService();
    CityService getCityService();
}
