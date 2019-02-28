package com.roman.shilov.hw7.order.domain;

import com.roman.shilov.hw7.cities.domain.City;
import com.roman.shilov.hw7.common.buisness.domain.BaseDomain;
import com.roman.shilov.hw7.countries.domain.Country;
import com.roman.shilov.hw7.user.domain.User;

public class Order extends BaseDomain {
    private City city;
    private Country country;
    private User user;
    private String description;
    private int price;

    public Order() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
