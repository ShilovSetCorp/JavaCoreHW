package com.roman.shilov.hw4.storage;

import com.roman.shilov.hw4.event.Event;
import com.roman.shilov.hw4.order.Order;
import com.roman.shilov.hw4.stuff.Stuff;
import com.roman.shilov.hw4.user.User;

public class Storage {
    private static final int CAPACITY = 10;
    public static User[] users = new User[CAPACITY];
    public static Order[] orders = new Order[CAPACITY];
    public static Event[] events = new Event[CAPACITY];
    public static Stuff[] stuff = new Stuff[CAPACITY];
}
