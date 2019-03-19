package com.roman.shilov.hw12.travelagency.common.solutions.repo;

public  interface BaseRepo <T, ID> {
    void deleteById(ID id);

    void printAll();

    T findById(ID id);

    void update(T entity);

    void insert(T entity);
}
