package com.acender.dbone.core.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
/**
 * Caching utility for storing query results.
 */
public class QueryCache {
    private static final Cache<String, Object> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();
    /**
     * Stores a result in the cache.
     * @param query The SQL query as key.
     * @param result The query result.
     */
    public static void store(String query, Object result){
        cache.put(query,result);
    }

    /**
     * Retrieves a cached result.
     * @param query The SQL query as key.
     * @return The cached result, or null if not found.
     */
    public static Object get(String query){
        return cache.getIfPresent(query);
    }
}
