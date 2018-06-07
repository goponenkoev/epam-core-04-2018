package com.epam.classwork.se08.pools.pool2;

import lombok.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("WeakerAccess")
public class ConnectionPool {

    private static final String PROPERTIES_FILE = "properties/database";
    private static final int DEFAULT_POOL_SIZE = 10;
    private static volatile ConnectionPool instance;
    private BlockingQueue<Connection> connectionQueue;

    public static synchronized void init() throws SQLException {
        if (instance == null) {
            ResourceBundle properties = ResourceBundle.getBundle(PROPERTIES_FILE);
            String url = properties.getString("db.url");
            String user = properties.getString("db.user");
            String password = properties.getString("db.password");
            int poolSize = Integer.parseInt(properties.getString("db.poolsize"));
            instance = new ConnectionPool(url, user, password, poolSize);
        }
    }

    // [1, _, _, _, _]
    //     ^
    //  &

    // [1, 2, _, _, _]
    //        ^
    //  &

    // [1, 2, _, _, _]
    //        ^
    //  &

    // [7, _, _, _, _]
    //     ^

    // [4, _, _, _, 2]
    //     ^

    private ConnectionPool(String url, String user, String password, int poolSize) throws SQLException {
        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connectionQueue.offer(DriverManager.getConnection(url, user, password));
        }
    }

    @NonNull
    public static ConnectionPool getInstance() {
        return instance;
    }

    public static void dispose() throws SQLException {
        if (instance != null) {
            instance.clearConnectionQueue();
            instance = null;
        }
    }

    public Connection takeConnection() {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            throw new InterruptedOnTakingConnectionException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                if (!connectionQueue.offer(connection)) {

                }
            } else {

            }
        } catch (SQLException e) {
            //"SQLException at conection isClosed () checking.
            // Connection not added", e
        }
    }

    public void executeQuery(Consumer<Connection> task) throws InterruptedException {
        Connection conn = connectionQueue.take();
        try {
            task.accept(conn);
        } finally {
            connectionQueue.put(conn);
        }

    }

    private void clearConnectionQueue() throws SQLException {
        Connection connection;
        while ((connection = connectionQueue.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }
}

