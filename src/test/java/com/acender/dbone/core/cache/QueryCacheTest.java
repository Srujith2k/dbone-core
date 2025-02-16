package com.acender.dbone.core.cache;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for QueryCache.
 */
class QueryCacheTest {

    @Test
    void testStoreAndRetrieveCache() {
        String query = "SELECT * FROM users";
        String result = "Mock Query Result";

        QueryCache.store(query, result);
        Object cachedResult = QueryCache.get(query);

        assertNotNull(cachedResult);
        assertEquals(result, cachedResult);
    }

    @Test
    void testCacheExpiration() throws InterruptedException {
        String query = "SELECT * FROM products";
        String result = "Mock Product Data";

        QueryCache.store(query, result);
        Thread.sleep(11 * 60 * 1000); // Wait 11 minutes (cache expiry is 10 mins)

        assertNull(QueryCache.get(query)); // Cache should be expired
    }
}
