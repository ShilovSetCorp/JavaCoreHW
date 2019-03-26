package com.roman.shilov.hw15.travelagency.order.repo.impl;

import com.roman.shilov.hw15.travelagency.order.domain.Order;
import com.roman.shilov.hw15.travelagency.order.search.OrderSearchCondition;
import com.roman.shilov.hw15.travelagency.order.search.OrdersOrderByField;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdersOrderingComponent {

    public void applyOrdering(List<Order> orders, OrderSearchCondition searchCondition) {
        Comparator<Order> orderComparator = null;

        OrdersOrderByField field = searchCondition.getOrderByField();

        switch (searchCondition.getOrderType()) {
            case SIMPLE: {
                orderComparator = OrderComparatorComponent.getInstance().getComparatorForField(field);
                break;
            }

            case COMPLEX: {
                orderComparator = OrderComparatorComponent.getInstance().getComplexComparator(field);
                break;
            }
        }

        if(orderComparator != null){
            switch (searchCondition.getOrderDirection()){
                case ASC:
                    Collections.sort(orders, orderComparator);
                    break;
                case DESC:
                    Collections.sort(orders, orderComparator.reversed());
                    break;
            }
        }
    }
}
