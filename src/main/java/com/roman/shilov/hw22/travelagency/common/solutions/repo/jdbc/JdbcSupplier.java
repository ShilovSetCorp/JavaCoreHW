package com.roman.shilov.hw22.travelagency.common.solutions.repo.jdbc;

public interface JdbcSupplier<T> {
    T get() throws Exception;
}
