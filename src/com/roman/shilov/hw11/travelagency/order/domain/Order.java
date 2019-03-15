package com.roman.shilov.hw11.travelagency.order.domain;

import com.roman.shilov.hw11.travelagency.cities.domain.City;
import com.roman.shilov.hw11.travelagency.common.buisness.domain.BaseDomain;
import com.roman.shilov.hw11.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw11.travelagency.user.domain.User;

public class Order extends BaseDomain {
    private City city;
    private BaseCountry baseCountry;
    private User user;
    private String description;
    private int price;

    public Order() {
    }

    public Order(City city, BaseCountry baseCountry, User user, int price) {
        this.city = city;
        this.baseCountry = baseCountry;
        this.user = user;
        this.price = price;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public BaseCountry getBaseCountry() {
        return baseCountry;
    }

    public void setBaseCountry(BaseCountry baseCountry) {
        this.baseCountry = baseCountry;
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
