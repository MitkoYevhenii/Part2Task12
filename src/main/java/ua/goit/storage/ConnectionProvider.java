package ua.goit.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnectionProvider {
    private List<Connection> connections;

    public Connection createConnection () throws SQLException {
        return DriverManager.getConnection(
                StorageConstants.CONNECTION_URL,
                StorageConstants.CONNECTION_USERNAME,
                StorageConstants.CONNECTION_PASSWORD);
    }

    public Connection createConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);

    }

    public void close() throws SQLException {
        for (Connection connection : connections) {
            if (connection.isClosed()) {
                continue;
            }
        }
    }
}
