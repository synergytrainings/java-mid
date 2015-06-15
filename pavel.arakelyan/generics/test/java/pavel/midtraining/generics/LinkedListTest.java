package pavel.midtraining.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by User on 6/15/15.
 */
public class LinkedListTest {
    LinkedList<Integer> list;

    @Before
    public void setUp(){
       list = new LinkedList<Integer>();
    }

    @Test
    public void testSize(){
        assertEquals(0, list.size());
        list.add(152);
        assertEquals(1, list.size());
    }

    @Test
    public void testAdd() {
        list.add(58);
        assertEquals(1, list.size());
        list.add(155);
        assertEquals(2, list.size());
        //Adding in the middle
        list.add(58,100);
        assertEquals(3, list.size());
    }

    @Test
    public void testGet() {
        list.add(55);
        assertEquals(new Integer(55), list.get(0));
    }

    @Test
    public void testRemove() {
        assertNull(list.remove());
        assertNull(list.remove(45));
        list.add(50);
        assertEquals(new Integer(50),list.remove());
        list.add(40);
        assertEquals(new Integer(40),list.remove(40));
        assertNull(list.remove(40));
        assertEquals(0,list.size());
    }
}
