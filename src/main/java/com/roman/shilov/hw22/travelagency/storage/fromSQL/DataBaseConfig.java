package com.roman.shilov.hw22.travelagency.storage.fromSQL;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum DataBaseConfig {
    URL("custom.database.url"),
    USER("custom.database.user"),
    PASSWORD("custom.database.password"),
    DRIVER("custom.database.driver");

    private String propName;
    private static Map<String, DataBaseConfig> propNameDbConfigMap = new HashMap<>();

    static {
        for(DataBaseConfig config : DataBaseConfig.values()){
            propNameDbConfigMap.put(config.propName, config);
        }
    }

    DataBaseConfig(String propName) {
        this.propName = propName;
    }

    public String getPropName() {
        return propName;
    }

    public static Optional<DataBaseConfig> getConfigByPropName(String propName) {
        return Optional.ofNullable(propNameDbConfigMap.get(propName));
    }
}
