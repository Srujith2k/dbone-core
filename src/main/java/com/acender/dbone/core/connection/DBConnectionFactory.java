package com.acender.dbone.core.connection;

/**
 * Factory class to provide database connections dynamically.
 */
public class DBConnectionFactory {

    /**
     * Creates and returns a DBConnection instance based on the database type.
     * @param dbType The type of database (e.g., "mysql", "postgresql").
     * @param host The database host.
     * @param port The database port.
     * @param dbName The database name.
     * @param user The username.
     * @param password The password.
     * @return A DBConnection object.
     * @throws IllegalArgumentException If the database type is not supported.
     */
    public static DBConnection getConnection(String dbType, String host, String port, String dbName, String user, String password) {
        return switch (dbType.toLowerCase()) {
            case "mysql" -> new MySQLConnection(host, port, dbName, user, password);
            case "postgresql" -> new PostgreSQLConnection(host, port, dbName, user, password);
            default -> throw new IllegalArgumentException("Unsupported database type: " + dbType);
        };
    }
}
