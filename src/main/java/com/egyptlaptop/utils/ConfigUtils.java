package com.egyptlaptop.utils;

import java.util.Properties;

import static com.egyptlaptop.constants.ConfigConstants.*;

public class ConfigUtils {

    private static final Properties properties;

    static {
        properties = PropertiesUtils.loadProperties(getPropertiesFilePath());
    }

    private static String getPropertiesFilePath()  {
        return switch (getEnv()) {
            case PRODUCTION -> PRODUCTION_PROPERTIES_PATH;
            case STAGING -> STAGING_PROPERTIES_PATH;
            default -> throw new RuntimeException("Environment is not supported");
        };
    }

    public static String getEnv(){
        String envFromSys = System.getProperty(ENV);
        return envFromSys != null ? envFromSys : STAGING;
    }

    public static String getBaseUrl(){
        String urlFromSys = System.getProperty(BASE_URL);
        return urlFromSys != null ? urlFromSys : properties.getProperty(BASE_URL);
    }



}
