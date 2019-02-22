package com.roman.shilov.hw4.user;

import com.roman.shilov.hw4.order.Order;

public class User {

    private Long id;
    private String companyName;
    private String contactName;
    private int yersOfCooperation;
    private Order[] orders;

    public User(){
    }

    public User(Long id, String companyName, String contactName) {
        this.id = id;
        this.companyName = companyName;
        this.contactName = contactName;
    }

    public User(String companyName, String contactName) {
        this.companyName = companyName;
        this.contactName = contactName;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public int getYersOfCooperation() {
        return yersOfCooperation;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setYersOfCooperation(int yersOfCooperation) {
        this.yersOfCooperation = yersOfCooperation;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                '}';
    }
}
