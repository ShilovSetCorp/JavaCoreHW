package com.roman.shilov.hw5.order.service;

import com.roman.shilov.hw5.common.buisness.service.BaseService;
import com.roman.shilov.hw5.order.domain.Order;

public interface OrderService extends BaseService {
    void add(Order order);

    Order findById(Long id);

    void delete(Order order);
}
