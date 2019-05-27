package atlassian;

import java.util.concurrent.LinkedBlockingQueue;

class MyConnection implements Connection {
    LinkedBlockingQueue<Connection> pool;
    Connection connection;
    MyConnection(LinkedBlockingQueue<Connection> pool, Connection c) {
        this.pool = pool;
        this.connection = c;
    }
    
    public void close() {
        try {
			pool.put(connection);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        connection = null;
    }
    
    public Object execute(Object query) {
        if (connection != null)
            return connection.execute(query);
         else
             throw new RuntimeException("Connection was closed already and cannot be reused");
    }
}