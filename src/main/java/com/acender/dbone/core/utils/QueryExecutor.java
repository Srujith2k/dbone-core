package com.acender.dbone.core.utils;

import com.acender.dbone.core.connection.DBConnection;
import com.acender.dbone.core.exceptions.QueryExecutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class for executing database queries with logging and error handling.
 */
public class QueryExecutor {

    private static final Logger logger = LogManager.getLogger(QueryExecutor.class);

    /**
     * Executes a SELECT query and logs errors.
     * @param connection The database connection.
     * @param query The SQL query.
     * @param params The query parameters.
     * @return The result set.
     */
    public static ResultSet executeQuery(DBConnection connection, String query, Object... params) {
        try {
            logger.debug("Executing query: {}", query);
            Connection rawConnection = connection.getRawConnection();
            PreparedStatement statement = prepareStatement(rawConnection, query, params);
            return statement.executeQuery();
        } catch (SQLException e) {
            logger.error("Query execution failed: {} | Error: {}", query, e.getMessage());
            throw new QueryExecutionException("Query execution failed.", e);
        }
    }

    /**
     * Executes an UPDATE, INSERT, or DELETE query and logs errors.
     * @param connection The database connection.
     * @param query The SQL query.
     * @param params The query parameters.
     * @return The number of rows affected.
     */
    public static int executeUpdate(DBConnection connection, String query, Object... params) {
        try {
            logger.debug("Executing update: {}", query);
            Connection rawConnection = connection.getRawConnection();
            PreparedStatement statement = prepareStatement(rawConnection, query, params);
            return statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Query execution failed: {} | Error: {}", query, e.getMessage());
            throw new QueryExecutionException("Query execution failed.", e);
        }
    }

    private static PreparedStatement prepareStatement(Connection connection, String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement;
    }
}
