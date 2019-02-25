package com.roman.shilov.hw5.order.repo.impl;

import com.roman.shilov.hw5.common.solutions.utils.ArrayUtils;
import com.roman.shilov.hw5.order.domain.Order;
import com.roman.shilov.hw5.order.repo.OrderRepo;

import java.util.Arrays;

import static com.roman.shilov.hw5.storage.storage.orders;

public class OrderDefaultRepo implements OrderRepo {
    private int orderIndex = -1;

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
