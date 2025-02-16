package com.acender.dbone.core.utils;

/**
 * Utility class for fetching configuration values.
 */
public class ConfigUtils {

    /**
     * Retrieves a value from the environment variables or system properties.
     * @param key The environment variable key.
     * @param defaultValue The default value if the variable is not set.
     * @return The environment variable value or default.
     */
    public static String getEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        return (value != null) ? value : defaultValue;
    }
}
