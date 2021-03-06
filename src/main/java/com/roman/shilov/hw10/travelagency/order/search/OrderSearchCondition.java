package com.roman.shilov.hw10.travelagency.order.search;

import com.roman.shilov.hw10.travelagency.cities.domain.City;
import com.roman.shilov.hw10.travelagency.common.buisness.search.BaseSearchConditition;
import com.roman.shilov.hw10.travelagency.countries.domain.Country;
import com.roman.shilov.hw10.travelagency.user.domain.User;

public class OrderSearchCondition extends BaseSearchConditition {
    private City city;
    private Country country;
    private User user;
    private String description;
    private int price;
    private OrdersOrderByField orderByField;

    public OrdersOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(OrdersOrderByField orderByField) {
        this.orderByField = orderByField;
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
