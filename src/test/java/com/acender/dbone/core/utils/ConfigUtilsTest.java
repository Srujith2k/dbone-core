package com.acender.dbone.core.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ConfigUtils.
 */
class ConfigUtilsTest {

    @Test
    void testGetEnvWithExistingVariable() {
        System.setProperty("TEST_ENV_VAR", "testValue");
        String result = ConfigUtils.getEnv("TEST_ENV_VAR", "defaultValue");
        assertEquals("testValue", result);
    }

    @Test
    void testGetEnvWithMissingVariable() {
        String result = ConfigUtils.getEnv("NON_EXISTENT_VAR", "defaultValue");
        assertEquals("defaultValue", result);
    }
}
