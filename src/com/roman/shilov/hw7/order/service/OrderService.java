package com.roman.shilov.hw7.order.service;

import com.roman.shilov.hw7.common.buisness.service.BaseService;
import com.roman.shilov.hw7.order.domain.Order;
import com.roman.shilov.hw7.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderService extends BaseService {
    void add(Order order);

    Order findById(Long id);

    void update(Order order);

    void delete(Order order);

    List<Order> search(OrderSearchCondition searchCondition);
}
