package com.roman.shilov.hw22.travelagency.storage.fromSQL;

import com.roman.shilov.hw22.travelagency.common.buisness.database.datasource.HikariCpDataSource;
import com.roman.shilov.hw22.travelagency.common.solutions.utils.CollectionUtils;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class H2DbInitor {

    private static final String DATABASE_CONFIG_PATH = "C:\\Users\\RomanSES\\epam\\src\\main\\resources\\com\\roman\\shilov\\hw22\\travelagency\\storage\\database\\config.properties";
    private static final String DDL_SCRIPT_PATH = "C:\\Users\\RomanSES\\epam\\src\\main\\resources\\com\\roman\\shilov\\hw22\\travelagency\\storage\\database\\create-schema.sql";
    private static final String DML_SCRIPT_PATH = "C:\\Users\\RomanSES\\epam\\src\\main\\resources\\com\\roman\\shilov\\hw22\\travelagency\\storage\\database\\init-data.sql";

    public void init() {
        try {
            prepareDataSourceConfig();
            createDataBaseStructure();
            fillDataBaseWithData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareDataSourceConfig() throws Exception {
        HikariCpDataSource.HikariCpDataSourceBuilder hikariCpDataSourceBuilder = new HikariCpDataSource.HikariCpDataSourceBuilder();
        Map<DataBaseConfig, String> dbConfigs = readDbConfigFromResources();

        dbConfigs.forEach((param, value) -> {
            switch (param) {

                case URL: {
                    hikariCpDataSourceBuilder.appendUrl(value);
                    break;
                }
                case USER: {
                    hikariCpDataSourceBuilder.appendUserName(value);
                    break;
                }
                case PASSWORD: {
                    hikariCpDataSourceBuilder.appendPassword(value);
                    break;
                }

                case DRIVER: {
                    hikariCpDataSourceBuilder.appendDriver(value);
                    break;
                }
            }
        });
        HikariCpDataSource.init(hikariCpDataSourceBuilder);
    }

    private Map<DataBaseConfig, String> readDbConfigFromResources() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(DATABASE_CONFIG_PATH));//this.getClass().getResourceAsStream(DATABASE_CONFIG_PATH));

        Map<DataBaseConfig, String> result = new HashMap<>();
        Arrays.stream(DataBaseConfig.values()).forEach(dbConfig ->
                result.put(dbConfig, props.getProperty(dbConfig.getPropName())));

        return result;
    }

    private void createDataBaseStructure() throws Exception {
        List<String> ddl = Files.readAllLines(Paths.get(DDL_SCRIPT_PATH));//this.getClass().getResource(DDL_SCRIPT_PATH).toURI()));

        try (Connection con = HikariCpDataSource.getInstance().getConnection();
             Statement statement = con.createStatement()) {
            statement.execute(String.join("", ddl));
        }
    }

    private void fillDataBaseWithData() throws Exception {
        List<String> sqls = prepareSqlsToInitData();
        if (CollectionUtils.isNotEmpty(sqls)) {
            for (String sql : sqls) {
                execSql(sql);
            }
        }
    }

    private List<String> prepareSqlsToInitData() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(DML_SCRIPT_PATH))){//this.getClass().getResource(DML_SCRIPT_PATH).toURI()))) {
            return stream.map(line -> {
                stringBuilder.append(line);
                if (line.endsWith(";")) {
                    String sql = stringBuilder.toString();
                    stringBuilder.setLength(0);
                    return sql;
                } else if (line.startsWith("-")) {
                    stringBuilder.setLength(0);
                    return null;
                }
                return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());
        }
    }

    private void execSql(String sql) throws Exception {
        try (Connection con = HikariCpDataSource.getInstance().getConnection();
             Statement statement = con.createStatement()) {
            statement.execute(sql);
        }
    }
}
