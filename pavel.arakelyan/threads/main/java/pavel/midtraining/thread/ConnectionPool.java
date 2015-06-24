package pavel.midtraining.thread;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mockito.Mockito.mock;

/**
 * This is a simple implementation of Connection Pool to show Multithreading use case
 */
public class ConnectionPool {
    /**
     * Holds max number of connections that can be in pool
     */
    private static final int MAX_SIZE = 5;

    private static final BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(MAX_SIZE);
    /**
     * Holds current count of opened connections
     */
    private static AtomicInteger connectionCount = new AtomicInteger();

    /**
     * Releases, puts back the connection into pool
     * @param conn to release
     */
    public static void releaseConnection(Connection conn){
        if(conn == null){
            return ;
        }
        pool.offer(conn);
    }

    public static Connection getConnection() {
        Connection conn = pool.peek();
        if (conn == null) {
            synchronized (connectionCount) {
                if (connectionCount.get() < MAX_SIZE) {
                    conn = mock(Connection.class);
                    pool.offer(conn);
                    connectionCount.incrementAndGet();
                }
            }
        }
        try {
            conn = pool.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " thread was interrupted");
        }
        return conn;
    }

    public static int size(){
        return pool.size();
    }

    public static boolean isEmpty(){
        return pool.size() == 0;
    }
}
