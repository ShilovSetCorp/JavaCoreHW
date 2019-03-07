package com.roman.shilov.hw10.travelagency;

import com.roman.shilov.hw10.travelagency.cities.domain.City;
import com.roman.shilov.hw10.travelagency.cities.service.CityService;
import com.roman.shilov.hw10.travelagency.common.buisness.application.StorageType;
import com.roman.shilov.hw10.travelagency.common.buisness.application.servicefactory.ServiceSupplier;
import com.roman.shilov.hw10.travelagency.common.buisness.search.OrderType;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.countries.domain.RockyCountry;
import com.roman.shilov.hw10.travelagency.countries.service.CountryService;
import com.roman.shilov.hw10.travelagency.order.service.OrderService;
import com.roman.shilov.hw10.travelagency.user.domain.User;
import com.roman.shilov.hw10.travelagency.user.search.UserSearchCondition;
import com.roman.shilov.hw10.travelagency.user.service.UserService;

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

        private void addUsers(){
            userService.add(new User("Roma", "Shilov"));
            userService.add(new User("Kostya", "Supov"));
            userService.add(new User("Kostya", "Ignatev"));
            userService.add(new User("Volodya", "Kuchman"));
        }

        private void addCountry(){
            Country switzerland = new RockyCountry();
            City zurich = new City();
            City davos = new City();
            switzerland.setCities(new City[] {zurich, davos});
            countryService.add(switzerland);
        }

        public void printUsers(){
            userService.printAll();
        }

        public Collection<User> search(long id){
            UserSearchCondition usc = new UserSearchCondition();
            usc.setId(id);
            usc.setOrderType(OrderType.ASC);
            return userService.search(usc);
        }

        public Collection<User> search(String name){
            UserSearchCondition usc = new UserSearchCondition();
            usc.setName(name);
            usc.setOrderType(OrderType.DESC);
            return userService.search(usc);
        }

    }

    public static void main(String[] args) {
        Application app = new Application();
        app.addUsers();
        app.addCountry();

        app.printUsers();
        System.out.println("------------------------");
        System.out.println(app.search(2));
        System.out.println("------------------------");
        System.out.println(app.search("Kostya"));

    }
}
