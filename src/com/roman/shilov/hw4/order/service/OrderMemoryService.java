package com.roman.shilov.hw4.order.service;

import com.roman.shilov.hw4.order.Order;
import com.roman.shilov.hw4.order.repo.OrderMemoryRepo;

public class OrderMemoryService {
    private OrderMemoryRepo repo = new OrderMemoryRepo();

    public void addIndex(Order order) {
        repo.addIndex(order);
    }

    public Order findOrderById(long id) {
        return repo.findOrderById(id);
    }

    public void deleteOrder(Order order) {
        repo.deleteOrder(order);
    }

    public void deleteOrder(Long id) {
        repo.deleteOrder(id);
    }

    public void printOrders() {
        repo.printOrders();
    }
}
