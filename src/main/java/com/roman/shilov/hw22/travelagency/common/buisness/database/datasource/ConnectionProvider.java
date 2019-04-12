package com.roman.shilov.hw22.travelagency.common.buisness.database.datasource;


import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ConnectionProvider {
    Connection getConnection() throws SQLException;
}
