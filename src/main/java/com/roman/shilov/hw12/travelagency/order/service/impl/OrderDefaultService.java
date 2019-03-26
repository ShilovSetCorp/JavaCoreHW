package com.roman.shilov.hw12.travelagency.order.service.impl;

import com.roman.shilov.hw12.travelagency.order.domain.Order;
import com.roman.shilov.hw12.travelagency.order.repo.OrderRepo;
import com.roman.shilov.hw12.travelagency.order.search.OrderSearchCondition;
import com.roman.shilov.hw12.travelagency.order.service.OrderService;

import java.util.List;

public class OrderDefaultService implements OrderService {
    private final OrderRepo repo;

    public OrderDefaultService(OrderRepo repo) {
        this.repo = repo;
    }

    @Override
    public void insert(Order order) {

        repo.insert(order);
    }

    @Override
    public Order findById(Long id) {
        if(id != null){
            return repo.findById(id);
        }else {
            return null;
        }
    }

    @Override
    public void update(Order order) {
        repo.update(order);
    }

    @Override
    public void delete(Order order) {
        if(order.getId() != null){
            repo.deleteById(order.getId());
        }
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        return repo.search(searchCondition);
    }

    @Override
    public void deleteById(Long id) {
        if(id != null){
            repo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        repo.printAll();
    }
}
