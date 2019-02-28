package com.roman.shilov.hw7.order.repo;

import com.roman.shilov.hw7.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw7.order.domain.Order;
import com.roman.shilov.hw7.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo {
    void add(Order order);

    Order findById(long id);

    List<Order> search(OrderSearchCondition searchCondition);
}
