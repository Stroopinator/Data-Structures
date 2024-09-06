import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntQueueTests{
    
    @Test
    public void testAdd(){
        IntQueue q = new IntQueue();
        q.add(10);
        q.add(3);
        q.add(5);
        assertEquals(3, q.size());
    }
    @Test
    public void testRemove(){
        IntQueue q = new IntQueue();
        q.add(10);
        q.add(3);
        q.add(5);
        assertEquals(10, q.remove().intValue());
        assertEquals(3, q.remove().intValue());
        assertEquals(5, q.remove().intValue());
        assertEquals(0, q.size());
    }
    
}
