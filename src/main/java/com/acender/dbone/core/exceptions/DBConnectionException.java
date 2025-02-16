package com.acender.dbone.core.exceptions;

/**
 * Exception thrown when a database connection fails.
 */
public class DBConnectionException extends RuntimeException {
    public DBConnectionException(String message) {
        super(message);
    }

    public DBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
