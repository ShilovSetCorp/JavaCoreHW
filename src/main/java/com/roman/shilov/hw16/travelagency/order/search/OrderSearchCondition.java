package com.roman.shilov.hw16.travelagency.order.search;

import com.roman.shilov.hw16.travelagency.cities.domain.City;
import com.roman.shilov.hw16.travelagency.common.buisness.search.BaseSearchConditition;
import com.roman.shilov.hw16.travelagency.countries.domain.BaseCountry;
import com.roman.shilov.hw16.travelagency.user.domain.User;

public class OrderSearchCondition extends BaseSearchConditition {
    private City city;
    private BaseCountry baseCountry;
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

    public boolean searchByUser(){
        return this.user != null;
    }

    public boolean searchByCountry(){
        return this.baseCountry != null;
    }

    public boolean searchByCity(){
        return this.city != null;
    }


    public boolean searchByDescription(){
        return this.description != null;
    }

    public boolean searchByPrice(){
        return this.price >= 0;
    }
}
