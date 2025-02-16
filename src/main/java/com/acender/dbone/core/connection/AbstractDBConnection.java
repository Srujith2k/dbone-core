package com.acender.dbone.core.connection;

import com.acender.dbone.core.exceptions.DBConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abstract class that implements common database connection logic for all databases.
 */
public abstract class AbstractDBConnection implements DBConnection {

    private static final Logger logger = LogManager.getLogger(AbstractDBConnection.class);

    protected Connection connection;
    protected final String url;
    protected final String user;
    protected final String password;

    public AbstractDBConnection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void connect() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
                logger.info("Database connected successfully.");
            }
        } catch (SQLException e) {
            logger.error("Database connection failed: {}", e.getMessage());
            throw new DBConnectionException("Database connection failed.", e);
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("✅ Database connection closed.");
            }
        } catch (SQLException e) {
            logger.warn("⚠ Error while closing connection: {}", e.getMessage());
        }
    }

    /**
     * Checks if the database connection is still active.
     * @return True if connected, false otherwise.
     */
    @Override
    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Provides direct access to the raw JDBC connection.
     * @return The active JDBC Connection.
     * @throws SQLException If the connection is invalid or closed.
     */
    @Override
    public Connection getRawConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connect();
        }
        return connection;
    }
}
