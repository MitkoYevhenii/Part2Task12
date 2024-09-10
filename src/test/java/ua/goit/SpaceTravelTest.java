package ua.goit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.goit.storage.ConnectionProvider;
import ua.goit.storage.FlywayService;
import ua.goit.storage.StorageConstants;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTravelTest {
    Connection connection;
    String connectionTestUrl = StorageConstants.CONNECTION_URL;
    String connectionUsername = StorageConstants.CONNECTION_USERNAME;
    String connectionPassword = StorageConstants.CONNECTION_PASSWORD;

    @BeforeEach
    void setUp() throws SQLException {
        FlywayService.initDataBase(
                connectionTestUrl,
                connectionUsername,
                connectionPassword
        );


        connection = new ConnectionProvider().createConnection(
                connectionTestUrl,
                connectionUsername,
                connectionPassword
        );
    }

    @Test
    void createDatabaseTest() throws SQLException {
        assertNotNull(connection);
        assertFalse(connection.isClosed());
        System.out.println("Database initialized and connection established.");
    }


    @AfterEach
    void tearDown() throws SQLException {
//        FlywayService.cleanDatabase();
//        connection.close();
    }
}