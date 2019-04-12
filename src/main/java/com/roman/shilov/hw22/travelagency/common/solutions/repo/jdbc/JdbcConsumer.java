package com.roman.shilov.hw22.travelagency.common.solutions.repo.jdbc;

@FunctionalInterface
public interface JdbcConsumer<T> {

    void consume(T t) throws Exception;
}
