package com.roman.shilov.hw4.order.repo;

import com.roman.shilov.hw4.order.Order;

import static com.roman.shilov.hw4.storage.Storage.orders;

public class OrderMemoryRepo {
    private int orderIndex = -1;

    public void addIndex(Order order){
        if(orderIndex == orders.length - 1){
            Order[] newOrders = new Order[orders.length * 2];
            System.arraycopy(orders, 0 , newOrders, 0, orders.length);
            orders = newOrders;
        }

        orderIndex++;
        orders[orderIndex] = order;
    }

    public Order findOrderById(long id){
        Integer orderIndex = findOrderIndexById(id);
        if(orderIndex != null){
            return orders[orderIndex];
        }
        return null;
    }

    public void deleteOrder(Order order){
        Integer foundIndex = findOrderIndexByEntity(order);

        if(foundIndex != null){
            deleteOrderByIndex(foundIndex);
            this.orderIndex--;
        }
    }

    public void deleteOrder(Long id){
        Integer foundIndex = findOrderIndexById(id);

        if(foundIndex != null){
            deleteOrderByIndex(foundIndex);
        }
    }

    private void deleteOrderByIndex(int index){
        Order[] newOrders = new Order[orders.length];
        System.arraycopy(orders, 0, newOrders, 0, index - 1);
        System.arraycopy(orders, index, newOrders, index - 1, orders.length - index);
        orders = newOrders;
        orderIndex--;
    }

    private Integer findOrderIndexByEntity(Order order){
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].equals(order)){
                return i;
            }
        }
        return null;
    }

    private Integer findOrderIndexById(Long id){
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].getId().equals(id)){
                return i;
            }
        }
        return null;
    }

    public void printOrders(){
        for(Order order : orders){
            System.out.println(order);
        }
    }
}
