package com.roman.shilov.hw16.travelagency;

import com.roman.shilov.hw16.travelagency.cities.domain.City;
import com.roman.shilov.hw16.travelagency.cities.search.CitySearchCondition;
import com.roman.shilov.hw16.travelagency.cities.service.CityService;
import com.roman.shilov.hw16.travelagency.common.buisness.application.StorageType;
import com.roman.shilov.hw16.travelagency.common.buisness.application.servicefactory.ServiceSupplier;
import com.roman.shilov.hw16.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw16.travelagency.countries.search.CountrySearchCondition;
import com.roman.shilov.hw16.travelagency.countries.service.CountryService;
import com.roman.shilov.hw16.travelagency.order.domain.Order;
import com.roman.shilov.hw16.travelagency.order.service.OrderService;
import com.roman.shilov.hw16.travelagency.reporting.Reporting;
import com.roman.shilov.hw16.travelagency.storage.initialisation.Initializator;
import com.roman.shilov.hw16.travelagency.storage.initialisation.InitorConstants;
import com.roman.shilov.hw16.travelagency.user.domain.User;
import com.roman.shilov.hw16.travelagency.user.search.UserSearchCondition;
import com.roman.shilov.hw16.travelagency.user.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

public class TravelAgencyDemo {

    public static class Application {
        static {
            ServiceSupplier.newSupplier(StorageType.MEMORY_COLLECTION);
        }

        private UserService userService = ServiceSupplier.setSupplier().getUserService();
        private OrderService orderService = ServiceSupplier.setSupplier().getOrderService();
        private CountryService countryService = ServiceSupplier.setSupplier().getCountryService();
        private CityService cityService = ServiceSupplier.setSupplier().getCityService();

        private void addUsers() {
            userService.insert(new User("Roma", "Shilov"));
            userService.insert(new User("Kostya", "Supov"));
            userService.insert(new User("Kostya", "Ignatev"));
            userService.insert(new User("Volodya", "Kuchman"));
        }

        private void addCountriesAndCities() {
            Initializator initializator = new Initializator(countryService);
            try {
                initializator.concurrentInit(Initializator.DataSourceType.XML_FILE, InitorConstants.INIT_DATA_XML_FILE1, InitorConstants.INIT_DATA_XML_FILE2);
              //  initializator.initCountriesAndCities(InitorConstants.INIT_DATA_XML_FILE, Initializator.DataSourceType.XML_FILE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void printUsers() {
            userService.printAll();
        }

        public void printCountries() {
            countryService.printAll();
        }


        public Collection<User> searchUser(String name) {
            UserSearchCondition usc = new UserSearchCondition();
            usc.setName(name);
            return userService.search(usc);
        }

        public Collection<City> searchCity(String name) {
            CitySearchCondition csc = new CitySearchCondition();
            csc.setName(name);
            return cityService.search(csc);
        }

        public Collection<BaseCountry> searchCountry(String name) {
            CountrySearchCondition csc = new CountrySearchCondition();
            csc.setName(name);
            return countryService.search(csc);
        }

        public void makeOrders() {
            ArrayList<User> users = (ArrayList<User>) searchUser("Roma");
            ArrayList<BaseCountry> countries = (ArrayList<BaseCountry>) searchCountry("Sweden");
            ArrayList<City> city = (ArrayList<City>) searchCity("Stockholm");
            orderService.insert(new Order(city.get(city.size() - 1), countries.get(countries.size() - 1), users.get(users.size() - 1), 1200));
        }

    }

    public static void main(String[] args) {
        Application app = new Application();
        app.addUsers();
        app.addCountriesAndCities();
        app.printCountries();

    //    app.printUsers();

        app.makeOrders();

        Reporting.reportMaker();
    }
}
