package com.hmrc.tech.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class CommonUtil {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    public static String getConfigValue(String key) {
        // Load properties from cucumber.properties file
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("src/test/resources/cucumber.properties")) {
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            logger.error("Error occurred while retrieving config value for the key {}: ", key, e);
            throw new RuntimeException(e);
        }
    }
}
