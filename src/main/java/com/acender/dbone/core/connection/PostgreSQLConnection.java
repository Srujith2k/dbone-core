package com.acender.dbone.core.connection;

/**
 * PostgreSQL database connection implementation using AbstractDBConnection.
 */
public class PostgreSQLConnection extends AbstractDBConnection {

    public PostgreSQLConnection(String host, String port, String dbName, String user, String password) {
        super("jdbc:postgresql://" + host + ":" + port + "/" + dbName, user, password);
    }
}
