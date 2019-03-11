package com.roman.shilov.hw10.travelagency.order.repo.impl;

import com.roman.shilov.hw10.travelagency.common.buisness.application.sequencecreator.SequenceCreator;
import com.roman.shilov.hw10.travelagency.order.domain.Order;
import com.roman.shilov.hw10.travelagency.order.repo.OrderRepo;
import com.roman.shilov.hw10.travelagency.order.search.OrderSearchCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.roman.shilov.hw10.travelagency.storage.Storage.ordersList;


public class OrderMemoryCollectionRepo implements OrderRepo {
    private OrdersOrderingComponent orderingComponent = new OrdersOrderingComponent();

    @Override
    public void insert(Order order) {
        order.setId(SequenceCreator.getNextId());
        ordersList.add(order);
    }

    @Override
    public Order findById(Long id) {
        return findOrderById(id);
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<Order> result = doSearch(searchCondition);
            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();

            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    private List<Order> doSearch(OrderSearchCondition searchCondition){

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

    @Override
    public void update(Order order) {
        Order found = findById(order.getId());
        found.setUser(order.getUser());
        found.setCity(order.getCity());
        found.setCountry(order.getCountry());
        found.setPrice(order.getPrice());
        found.setDescription(order.getDescription());
    }

    @Override
    public void deleteById(Long id) {
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
