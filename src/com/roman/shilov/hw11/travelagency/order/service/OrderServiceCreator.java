package com.roman.shilov.hw11.travelagency.order.service;

import com.roman.shilov.hw11.travelagency.common.buisness.application.StorageType;
import com.roman.shilov.hw11.travelagency.order.repo.impl.OrderMemoryArrayRepo;
import com.roman.shilov.hw11.travelagency.order.repo.impl.OrderMemoryCollectionRepo;
import com.roman.shilov.hw11.travelagency.order.service.impl.OrderDefaultService;

public final class OrderServiceCreator {
    private OrderServiceCreator() {
    }

    public static OrderService getCityService(StorageType storageType){
        switch (storageType){

            case MEMORY_ARRAY:
                return new OrderDefaultService(new OrderMemoryArrayRepo());

            case MEMORY_COLLECTION:
                return new OrderDefaultService(new OrderMemoryCollectionRepo());

            default: return null;
        }
    }
}
