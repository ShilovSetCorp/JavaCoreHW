package com.roman.shilov.hw6.order.repo.impl;

import com.roman.shilov.hw6.common.solutions.utils.ArrayUtils;
import com.roman.shilov.hw6.order.domain.Order;
import com.roman.shilov.hw6.order.repo.OrderRepo;
import com.roman.shilov.hw6.order.search.OrderSearchCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.roman.shilov.hw6.storage.Storage.orders;

public class OrderMemoryArrayRepo implements OrderRepo {
    private static final Order[] EMPTY_ORDERS_ARR = new Order[0];
    private int orderIndex = -1;

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

            Order[] result = new Order[orders.length];
            int resultIndex = 0;

            for (Order order : orders) {
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
                        result[resultIndex] = order;
                        resultIndex++;
                    }
                }
            }

            if (resultIndex > 0) {
                Order[] toReturn = new Order[resultIndex];
                System.arraycopy(result, 0, toReturn, 0, resultIndex);
                return new ArrayList<>(Arrays.asList(toReturn));
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void add(Order order) {
        if(orderIndex == orders.length - 1) {
            Order[] newArrOrders = new Order[orders.length * 2];
            System.arraycopy(orders,0, newArrOrders, 0, orders.length);
            orders = newArrOrders;
        }

        orderIndex++;
        orders[orderIndex] = order;
    }

    @Override
    public Order findById(long id) {
        Integer orderIndex = findOrderIndexById(id);
        if(orderIndex != null){
            return orders[orderIndex];
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        Integer orderIndex = findOrderIndexById(id);

        if(orderIndex != null){
            deleteOrderByIndex(orderIndex);
        }
    }

    private void deleteOrderByIndex(int index){
        ArrayUtils.removeElement(orders, index);
        orderIndex--;
    }

    @Override
    public void printAll() {
        Arrays.stream(orders).forEach(System.out::println);
    }

    private Integer findOrderIndexById(Long orderId){
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].getId().equals(orderId)){
                return i;
            }
        }
        return null;
    }
}
