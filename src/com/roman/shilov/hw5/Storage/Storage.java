package com.roman.shilov.hw5.storage;

import com.roman.shilov.hw5.cities.domain.City;
import com.roman.shilov.hw5.countries.domain.Country;
import com.roman.shilov.hw5.order.domain.Order;
import com.roman.shilov.hw5.user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final int CAPACITY = 5;
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];

    public static List<User> userList = new ArrayList<>();
    public static List<Country> countryList = new ArrayList<>();
    public static List<Order> ordersList = new ArrayList<>();
    public static List<City> cityList = new ArrayList<>();
}
