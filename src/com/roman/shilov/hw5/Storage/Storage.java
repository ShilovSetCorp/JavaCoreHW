package com.roman.shilov.hw5.storage;

import com.roman.shilov.hw5.cities.domain.City;
import com.roman.shilov.hw5.countries.domain.Country;
import com.roman.shilov.hw5.order.domain.Order;
import com.roman.shilov.hw5.user.domain.User;

public class Storage {
    private static final int CAPACITY = 5;
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
    public static Country[] countries = new Country[CAPACITY];
    public static City[] cities = new City[CAPACITY];
}
