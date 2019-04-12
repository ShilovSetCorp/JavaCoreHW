package com.roman.shilov.hw22.travelagency.common.solutions.repo;

import java.util.Collection;

public  interface BaseRepo <T, ID> {
    void deleteById(ID id);

    void printAll();

    T findById(ID id);

    void update(T entity);

    T insert(T entity);

    void insert(Collection<T> items);
}
