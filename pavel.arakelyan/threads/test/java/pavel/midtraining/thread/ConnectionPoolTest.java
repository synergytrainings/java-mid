package pavel.midtraining.thread;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * 
 */
public class ConnectionPoolTest {

    @Test
    public void testGetConnection(){
        assertTrue(ConnectionPool.isEmpty());
        Connection connection = ConnectionPool.getConnection();
        assertNotNull(connection);
    }

    /**
     * Getting a connection when a connection has already been got and not released gives another, different connection
     */
    @Test
    public void testNewConnection(){
        Connection connection1 = ConnectionPool.getConnection();
        assertNotNull(connection1);
        Connection connection2 = ConnectionPool.getConnection();
        assertNotEquals(connection1,connection2);
    }

    /**
     * Getting a connection after one has been released gives you the same connection
     */
    @Test
    public void testReleasedConnection(){
        Connection connection1 = ConnectionPool.getConnection();
        assertTrue(ConnectionPool.isEmpty());
        ConnectionPool.releaseConnection(connection1);
        Connection connection2 = ConnectionPool.getConnection();
        assertEquals(connection1, connection2);
    }
}
