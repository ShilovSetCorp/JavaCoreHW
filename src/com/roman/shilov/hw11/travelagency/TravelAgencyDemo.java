package com.roman.shilov.hw11.travelagency;

import com.roman.shilov.hw11.travelagency.cities.service.CityService;
import com.roman.shilov.hw11.travelagency.common.buisness.application.StorageType;
import com.roman.shilov.hw11.travelagency.common.buisness.application.servicefactory.ServiceSupplier;
import com.roman.shilov.hw11.travelagency.common.buisness.initialisation.Initilisator;
import com.roman.shilov.hw11.travelagency.countries.service.CountryService;
import com.roman.shilov.hw11.travelagency.order.service.OrderService;
import com.roman.shilov.hw11.travelagency.reporting.Reporting;
import com.roman.shilov.hw11.travelagency.user.domain.User;
import com.roman.shilov.hw11.travelagency.user.search.UserSearchCondition;
import com.roman.shilov.hw11.travelagency.user.service.UserService;

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
            userService.insert(new User("Roma", "Shilov"));
            userService.insert(new User("Kostya", "Supov"));
            userService.insert(new User("Kostya", "Ignatev"));
            userService.insert(new User("Volodya", "Kuchman"));
        }

        private void addCountriesAndCities(){
            Initilisator.readerFromFile();

        }

        public void printUsers(){
            userService.printAll();
        }

        public void printCountries(){
            countryService.printAll();
        }

        public Collection<User> search(long id){
            UserSearchCondition usc = new UserSearchCondition();
            usc.setId(id);
           // usc.setOrderType(OrderDirection.ASC);
            return userService.search(usc);
        }

        public Collection<User> search(String name){
            UserSearchCondition usc = new UserSearchCondition();
            usc.setName(name);
       //     usc.setOrderType(OrderType.DESC);
            return userService.search(usc);
        }

    }

    public static void main(String[] args) {
        Application app = new Application();
     //   app.addUsers();
        app.addCountriesAndCities();
        app.printCountries();


//        app.printUsers();
//        System.out.println("------------------------");
//        System.out.println(app.search(2));
//        System.out.println("------------------------");
//        System.out.println(app.search("Kostya"));

        Reporting.reportMaker();
    }
}
