package com.acender.dbone.core.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Interface that defines methods for database connection management and querying.
 */
public interface DBConnection {

    /**
     * Establishes a connection to the database.
     *
     * @throws SQLException If an error occurs while establishing the connection.
     */
    void connect() throws SQLException;

    /**
     * Checks if the database connection is currently active.
     * @return true if the connection is active, false otherwise.
     */
    boolean isConnected();

    /**
     * Closes the database connection.
     */
    void disconnect();

    /**
     * Provides direct access to the underlying JDBC Connection object.
     * @return The active JDBC Connection.
     * @throws SQLException If the connection is invalid or closed.
     */
    Connection getRawConnection() throws SQLException;
}
