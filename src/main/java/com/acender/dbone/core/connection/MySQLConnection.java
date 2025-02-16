package com.acender.dbone.core.connection;

/**
 * MySQL database connection implementation using AbstractDBConnection.
 */
public class MySQLConnection extends AbstractDBConnection {

    public MySQLConnection(String host, String port, String dbName, String user, String password) {
        super("jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useSSL=false", user, password);
    }
}
