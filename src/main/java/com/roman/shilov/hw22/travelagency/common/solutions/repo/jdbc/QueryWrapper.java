package com.roman.shilov.hw22.travelagency.common.solutions.repo.jdbc;

import com.roman.shilov.hw22.travelagency.common.buisness.database.datasource.HikariCpDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueryWrapper {

    public static <T> List<T> select(String sql, Connection connection, ResultSetExtractor<T> extractor) throws Exception {

        try(PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery()) {

            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(extractor.extract(resultSet));
            }
            return result;
        }
    }

    public static <T> List<T> select(String sql, ResultSetExtractor<T> extractor) throws Exception {
        try(Connection connection = HikariCpDataSource.getInstance().getConnection()) {
            return select(sql, connection, extractor);
        }
    }

    public static <T> List<T> select(String sql, Connection connection, ResultSetExtractor<T> mapper, PreparedStatementIdentityFunc psIdentityFunc) throws Exception {
        try (PreparedStatement ps = psIdentityFunc.applyParamsAndGet(connection.prepareStatement(sql));
            ResultSet rs = ps.executeQuery()){

            List<T> result = new ArrayList<>();
            while(rs.next()) {
                result.add(mapper.extract(rs));
            }

            return result;
        }
    }

    public static <T> List<T> select(String sql, ResultSetExtractor<T> mapper, PreparedStatementIdentityFunc psIdentityFunc) throws Exception {
        try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
            return select(sql, connection, mapper, psIdentityFunc);
        }
    }

    public static <T> List<T> select(String sql, Connection connection, ResultSetExtractor<T> mapper, PreparedStatementConsumer psConsumer) throws Exception {
        JdbcSupplier<PreparedStatement> supplier = () -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            psConsumer.consume(preparedStatement);
            return preparedStatement;
        };

        try (PreparedStatement ps = supplier.get();
              ResultSet rs = ps.executeQuery()){

            List<T> result = new ArrayList<>();
            while (rs.next()){
                result.add(mapper.extract(rs));
            }
            return result;
        }
    }

    public static <T> List<T> select(String sql, ResultSetExtractor<T> mapper, PreparedStatementConsumer psConsumer) throws Exception {
        try(Connection connection = HikariCpDataSource.getInstance().getConnection()){
            return select(sql, connection, mapper, psConsumer);
        }
    }

    public static <T> Optional<T> selectOne(String sql, Connection connection, ResultSetExtractor<T> extractor) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                return Optional.of(extractor.extract(resultSet));
            }else {
                return Optional.empty();
            }
        }
    }

    public static <T> Optional<T> selectOne(String sql, ResultSetExtractor<T> extractor) throws Exception {
        try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
            return selectOne(sql, connection, extractor);
        }
    }

    public static <T> Optional<T> selectOne(String sql, Connection connection, ResultSetExtractor<T> extractor, PreparedStatementIdentityFunc psIdentiryFunc) throws Exception {
        try (PreparedStatement ps = psIdentiryFunc.applyParamsAndGet(connection.prepareStatement(sql));
              ResultSet resultSet = ps.executeQuery()) {
            if (resultSet.next()) {
                return Optional.of(extractor.extract(resultSet));
            }else {
                return Optional.empty();
            }
        }
    }

    public static <T> Optional<T> selectOne(String sql, ResultSetExtractor<T> extractor, PreparedStatementIdentityFunc psIdentityFunc) throws Exception {
        try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
            return selectOne(sql, connection, extractor, psIdentityFunc);
        }
    }

    public static <T> Optional<T> selectOne(String sql, Connection connection, ResultSetExtractor<T> extractor, PreparedStatementConsumer psConsumer) throws Exception {
        JdbcSupplier<PreparedStatement> supplier = () -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            psConsumer.consume(preparedStatement);
            return preparedStatement;
        };

        try (PreparedStatement ps = supplier.get();
              ResultSet resultSet = ps.executeQuery()){
            if (resultSet.next()) {
                return Optional.of(extractor.extract(resultSet));
            }else {
                return Optional.empty();
            }
        }
    }


    public static <T> Optional<T> selectOne(String sql, ResultSetExtractor<T> extractor, PreparedStatementConsumer psConsumer) throws Exception {
        try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
            return selectOne(sql, connection, extractor, psConsumer);
        }
    }

    private static int executeUpdate(String sql, Connection connection, PreparedStatementIdentityFunc psIndentityFunc) throws Exception {
        try (PreparedStatement ps = psIndentityFunc.applyParamsAndGet(connection.prepareStatement(sql))) {
            return ps.executeUpdate();
        }
    }

    private static int executeUpdate(String sql, Connection connection, PreparedStatementConsumer psConsumer) throws Exception {
        PreparedStatementSupplier supplier = () -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            psConsumer.consume(preparedStatement);
            return preparedStatement;
        };

        try (PreparedStatement ps = supplier.get()){
            return ps.executeUpdate();
        }
    }

    private static int executeUpdate(String sql, PreparedStatementIdentityFunc psIdentityFunc) throws Exception {
        try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
            return executeUpdate(sql, connection, psIdentityFunc);
        }
    }

    private static int executeUpdate(String sql, PreparedStatementConsumer psConsumer) throws Exception {
        try (Connection connection = HikariCpDataSource.getInstance().getConnection()) {
            return executeUpdate(sql, connection, psConsumer);
        }
    }

    public static<T> Optional<T> executeUpdatingReturningGeneratedKey(String sql, Connection connection,
                                                                        PreparedStatementIdentityFunc psIdentityFunc,
                                                                        ResultSetExtractor<T> keyExtractor) throws Exception {

        try (PreparedStatement ps = psIdentityFunc.applyParamsAndGet(connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS))){
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()) {
                    return Optional.of(keyExtractor.extract(rs));
                }else {
                    return Optional.empty();
                }
            }
        }
    }

    public static<T> Optional<T> executeUpdatingReturningGeneratedKey(String sql, PreparedStatementIdentityFunc psIdentityFumc,
                                                                        ResultSetExtractor<T> keyExtractor) throws Exception {

        try (Connection connection = HikariCpDataSource.getInstance().getConnection()){
            return executeUpdatingReturningGeneratedKey(sql, connection, psIdentityFumc, keyExtractor);
        }
    }

    public static<T> Optional<T> executeUpdatingReturningGeneratedKey(String sql, Connection connection, PreparedStatementConsumer psConsumer,
                                                                        ResultSetExtractor<T> keyExtractor) throws Exception {

        JdbcSupplier<PreparedStatement> supplier = () -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            psConsumer.consume(preparedStatement);
            return preparedStatement;
        };

        try (PreparedStatement ps = supplier.get()){
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()) {
                    return Optional.of(keyExtractor.extract(rs));
                }else {
                    return Optional.empty();
                }
            }
        }
    }

    public static<T> Optional<T> executeUpdatingReturningGeneratedKey(String sql, PreparedStatementConsumer psConsumer,
                                                                        ResultSetExtractor<T> keyExtractor) throws Exception {

        try (Connection connection = HikariCpDataSource.getInstance().getConnection()){
            return executeUpdatingReturningGeneratedKey(sql, connection, psConsumer, keyExtractor);
        }
    }
}
