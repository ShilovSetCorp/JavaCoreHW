package com.roman.shilov.hw4.order;

import com.roman.shilov.hw4.event.Event;
import com.roman.shilov.hw4.stuff.Stuff;
import com.roman.shilov.hw4.user.User;

public class Order {
    private Long id;
    private Event event;
    private User user;
    private Stuff[] stuff;
    private int price;
    private String description;

    public Order() {}

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public User getUser() {
        return user;
    }

    public Stuff[] getStuff() {
        return stuff;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStuff(Stuff[] stuff) {
        this.stuff = stuff;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
