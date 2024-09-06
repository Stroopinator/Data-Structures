package PriorityQueues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PriorityQueuesTests {

    @Test
    public void testHeapIntPriorityQueue() {
        HeapIntPriorityQueue pq = new HeapIntPriorityQueue();
        assertEquals(0, pq.size());
        assertNull(pq.peek());
        assertTrue(pq.isEmpty());
        pq.add(6);
        assertEquals(1, pq.size());
        assertEquals(6, (int)pq.peek());
        pq.add(10);
        assertEquals(2, pq.size());
        assertEquals(6, (int)pq.peek());
        pq.add(-1);
        assertEquals(3, pq.size());
        assertEquals(-1, (int)pq.peek());
        assertFalse(pq.isEmpty());
        assertEquals(-1, (int)pq.remove());
        assertEquals(2, pq.size());
        assertEquals(6, (int)pq.remove());
        assertEquals(10, (int)pq.remove());
        assertNull(pq.remove());
        assertEquals(0, pq.size());
        assertTrue(pq.isEmpty());
    }

    @Test
    public void point_tests() {
        Point p = new Point(0, 0);
        assertEquals(0, p.compareTo(Point.ORIGIN));
        assertEquals(0, Point.ORIGIN.compareTo(p));
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        assertEquals(-1, p1.compareTo(p2));
        assertEquals(1, p2.compareTo(p1));
    }

    @Test
    public void testHeapPriorityQueue() {
        HeapPriorityQueue<Point> pq = new HeapPriorityQueue<Point>(Point.class);
        assertEquals(0, pq.size());
        Point p1 = new Point(1, 2);
        pq.add(p1);
        assertEquals(1, pq.size());
        Point expected = new Point(1,2);
        //assertEquals(new Point(1, 2), pq.peek()); // does not work
        assertEquals(0, expected.compareTo(pq.peek()));
        assertEquals(expected.toString(), pq.peek().toString());
        assertEquals(p1, pq.peek());

        Point p2 = new Point(4, 3);
        pq.add(p2);
        Point p3 = new Point(-1, 3);
        pq.add(p3);
        assertEquals(3, pq.size());
        assertEquals(p1, pq.remove());
        assertEquals(2, pq.size());
        assertEquals(p3, pq.remove());
        assertEquals(p2, pq.remove());
        assertNull(pq.remove());
        assertTrue(pq.isEmpty());
    }
}
