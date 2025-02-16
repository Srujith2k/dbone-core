package com.acender.dbone.core.connection;

import com.acender.dbone.core.connection.DBConnection;
import com.acender.dbone.core.connection.DBConnectionFactory;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {
    @Test
    void testMySQLConnection() throws SQLException {
        DBConnection connection = DBConnectionFactory.getConnection(
                "mysql", "localhost", "3306", "testdb", "root", "password");

        connection.connect();
        assertTrue(connection.isConnected());

        connection.disconnect();
        assertFalse(connection.isConnected());
    }

    @Test
    void testPostgresSQLConnection() throws SQLException{
        DBConnection connection = DBConnectionFactory.getConnection("postgresql", "localhost", "5432", "testDB", "postgres", "root");

        connection.connect();
        assertTrue(connection.isConnected());

        connection.disconnect();
        assertFalse(connection.isConnected());
    }


}
