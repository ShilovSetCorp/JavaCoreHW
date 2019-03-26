package com.roman.shilov.hw9.travelagency.order.repo;

import com.roman.shilov.hw9.travelagency.common.buisness.repo.BaseRepo;
import com.roman.shilov.hw9.travelagency.order.domain.Order;
import com.roman.shilov.hw9.travelagency.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo {
    void add(Order order);

    Order findById(long id);

    List<Order> search(OrderSearchCondition searchCondition);

    void update(Order order);
}
