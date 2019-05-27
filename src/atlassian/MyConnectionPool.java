package atlassian;

// Connection Pool Code
class MyConnectionPool implements ConnectionPool {
    LinkedBlockingQueue<Connection> pool;
    MyConnectionPool(List<Connection> connections) {
        for (Connection c : connections) {
            pool.add(connection);
    }
    Connection getConnection() {
        // Waits until a connection is available        
        return new MyConnection(pool, pool.take());
    }
}