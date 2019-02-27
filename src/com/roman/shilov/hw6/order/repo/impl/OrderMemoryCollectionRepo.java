package com.roman.shilov.hw6.order.repo.impl;

import com.roman.shilov.hw6.order.domain.Order;
import com.roman.shilov.hw6.order.repo.OrderRepo;
import com.roman.shilov.hw6.order.search.OrderSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw6.storage.Storage.ordersList;

public class OrderMemoryCollectionRepo implements OrderRepo {
    @Override
    public void add(Order order) {
        ordersList.add(order);
    }

    @Override
    public Order findById(long id) {
        return findOrderById(id);
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByUser = searchCondition.getUser() != null;
            boolean searchByCountry = searchCondition.getCountry() != null;
            boolean searchByCity = searchCondition.getCity() != null;
            boolean searchByDescription = searchCondition.getDescription() != null;
            boolean searchByPrice = searchCondition.getPrice() > 0;

            List<Order> result = new ArrayList<>();
            for (Order order : ordersList) {
                if (order != null) {
                    boolean found = true;
                    if (searchByUser) {
                        found = searchCondition.getUser().equals(order.getUser());
                    }

                    if (found && searchByCountry) {
                        found = searchCondition.getCountry().equals(order.getCountry());
                    }

                    if (found && searchByCity) {
                        found = searchCondition.getCity().equals(order.getCity());
                    }

                    if (found && searchByDescription) {
                        found = searchCondition.getDescription().equals(order.getDescription());
                    }

                    if (found && searchByPrice) {
                        found = searchCondition.getPrice() == order.getPrice();
                    }

                    if (found) {
                        result.add(order);
                    }
                }
            }
            return result;
        }
    }

    @Override
    public void deleteById(long id) {
        Order found = findOrderById(id);

        if (found != null) {
            ordersList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for(Order order: ordersList){
            System.out.println(order);
        }
    }

    private Order findOrderById(long userId) {
        for (Order order : ordersList) {
            if (Long.valueOf(userId).equals(order.getId())) {
                return order;
            }
        }
        return null;
    }
}
