package com.roman.shilov.hw22.travelagency.order.repo.impl.jdbc;

import com.roman.shilov.hw22.travelagency.order.domain.Order;

import java.sql.ResultSet;

public final class OrderMapper {
    private OrderMapper() {
    }

    public static Order mapOrder(ResultSet rs) throws Exception {
        try {
            Order order = new Order();
            order.setId(rs.getLong("ID"));
            order.setCityId(rs.getLong("CITY_ID"));
            order.setCountryId(rs.getLong("COUNTRY_ID"));
            order.setUserId(rs.getLong("USER_ID"));
            order.setPrice(rs.getInt("PRICE"));
            order.setDescription(rs.getString("DESCRIPTION"));
            return order;
        }catch (Exception e) {
            throw new Exception("Order bad");
        }
    }
}
