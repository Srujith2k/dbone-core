package com.acender.dbone.core.utils;

import com.acender.dbone.core.connection.DBConnection;
import com.acender.dbone.core.connection.DBConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for QueryExecutor.
 */
class QueryExecutorTest {

    private DBConnection connection;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DBConnectionFactory.getConnection(
                "mysql", "localhost", "3306", "testdb", "root", "encrypted_password"
        );
        connection.connect();
    }

    @AfterEach
    void tearDown() {
        connection.disconnect();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        String query = "SELECT username FROM users WHERE id = ?";
        ResultSet resultSet = QueryExecutor.executeQuery(connection, query, 1);

        assertNotNull(resultSet);
        assertTrue(resultSet.next());
        assertEquals("testUser", resultSet.getString("username"));
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        String insertQuery = "INSERT INTO users (username, email) VALUES (?, ?)";
        int rowsAffected = QueryExecutor.executeUpdate(connection, insertQuery, "newUser", "newuser@example.com");

        assertEquals(1, rowsAffected);
    }
}
