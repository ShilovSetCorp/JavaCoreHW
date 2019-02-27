package com.roman.shilov.hw6.order.service;

import com.roman.shilov.hw6.common.buisness.service.BaseService;
import com.roman.shilov.hw6.order.domain.Order;
import com.roman.shilov.hw6.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService {
    void add(Order order);

    Order findById(Long id);

    void delete(Order order);

    List<Order> search(OrderSearchCondition searchCondition);
}
