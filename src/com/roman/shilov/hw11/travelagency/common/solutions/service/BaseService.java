package com.roman.shilov.hw11.travelagency.common.solutions.service;


public interface BaseService<T, ID> {

    void insert(T entity);

    void update(T entity);

    T findById(ID id);

    void delete(T entity);

    void deleteById(ID id);

    void printAll();

}
