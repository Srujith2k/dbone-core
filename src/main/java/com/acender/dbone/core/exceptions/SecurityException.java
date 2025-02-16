package com.acender.dbone.core.exceptions;

/**
 * Exception thrown when a security-related operation fails.
 */
public class SecurityException extends RuntimeException {
    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }
}
