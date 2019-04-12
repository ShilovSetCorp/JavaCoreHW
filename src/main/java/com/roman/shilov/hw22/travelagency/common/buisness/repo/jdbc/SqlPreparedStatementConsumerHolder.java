package com.roman.shilov.hw22.travelagency.common.buisness.repo.jdbc;


import com.roman.shilov.hw22.travelagency.common.solutions.repo.jdbc.PreparedStatementConsumer;

import java.util.List;

public class SqlPreparedStatementConsumerHolder {
    private String sql;
    private List<PreparedStatementConsumer> preparedStatementConsumers;


    public SqlPreparedStatementConsumerHolder(String sql, List<PreparedStatementConsumer> preparedStatementConsumers) {
        this.sql = sql;
        this.preparedStatementConsumers = preparedStatementConsumers;
    }

    public String getSql() {
        return sql;
    }

    public List<PreparedStatementConsumer> getPreparedStatementConsumers() {
        return preparedStatementConsumers;
    }
}
