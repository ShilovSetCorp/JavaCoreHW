package com.roman.shilov.hw17.travelagency.order.repo;

import com.roman.shilov.hw17.travelagency.common.solutions.repo.BaseRepo;
import com.roman.shilov.hw17.travelagency.order.domain.Order;
import com.roman.shilov.hw17.travelagency.order.search.OrderSearchCondition;

import java.util.List;

public interface OrderRepo extends BaseRepo<Order, Long> {

    List<Order> search(OrderSearchCondition searchCondition);

}
