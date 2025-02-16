package com.acender.dbone.core.exceptions;

import com.acender.dbone.core.connection.DBConnection;
import com.acender.dbone.core.connection.DBConnectionFactory;
import com.acender.dbone.core.utils.QueryExecutor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for exception handling.
 */
class ExceptionHandlingTest {

    @Test
    void testDBConnectionException() {
        Exception exception = assertThrows(DBConnectionException.class, () -> {
            DBConnection connection = DBConnectionFactory.getConnection("mysql", "invalid_host", "3306", "testdb", "user", "password");
            connection.connect();
        });

        assertTrue(exception.getMessage().contains("Database connection failed"));
    }

    @Test
    void testQueryExecutionException() {
        Exception exception = assertThrows(QueryExecutionException.class, () -> {
            DBConnection connection = DBConnectionFactory.getConnection("postgresql", "localhost", "5432", "testDB", "postgres", "root");
            connection.connect();
            QueryExecutor.executeQuery(connection, "INVALID SQL QUERY");
        });

        assertTrue(exception.getMessage().contains("Query execution failed"));
    }
}
