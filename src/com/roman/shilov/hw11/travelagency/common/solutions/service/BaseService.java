package com.roman.shilov.hw11.travelagency.common.solutions.service;


import com.roman.shilov.hw11.travelagency.common.buisness.exceptions.BasicTravelCheckedException;
import com.roman.shilov.hw11.travelagency.user.service.exceptions.UserStillHasOrdersException;

public interface BaseService<T, ID> {

    void insert(T entity);

    void update(T entity);

    T findById(ID id);

    void delete(T entity) throws BasicTravelCheckedException;

    void deleteById(ID id);

    void printAll();

}
