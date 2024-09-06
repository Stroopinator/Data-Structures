package Calculator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.Assert.fail;

import org.junit.Test;

import Calculator.main.RawNode;

public class RawNode_tests {

    @Test
    public void test_createRawNode() {
        // TODO: Create a new RawNode
        RawNode mine = RawNode.createNode("15");

        // TODO: and verify the content is as expected
        assertEquals("15", mine.getRawContent());
        // TODO: and that its links are null.
        assertNull(mine.getNext());
        assertNull(mine.getPrev());
    }
    
    @Test
    public void test_addNext() {
        // TODO: Create two nodes, n1 and n2, add one next to the other and
        RawNode n1 = RawNode.createNode("1");
        RawNode n2 = RawNode.createNode("2");
        n1.addNext(n2);
        // TODO: verify their links are pointing to their respective nodes.
        assertEquals(n2, n1.getNext());
        assertEquals(n1, n2.getPrev());
        // TODO: Create a third node n3, add it after n1 and verify its links
        RawNode n3 = RawNode.createNode("3");
        n1.addNext(n3);
        // TODO: are pointing to n1 and n2 respectively, and that
        assertEquals(n1, n3.getPrev());
        assertEquals(n2, n3.getNext());
        // TODO: the n1 and n2 links were adjusted accordingly as well.
        assertEquals(n3, n1.getNext());
        assertEquals(n3, n2.getPrev());
    }
    
    @Test
    public void test_addTail() {
        RawNode n1 = RawNode.createNode("1");
        RawNode n2 = RawNode.createNode("2");
        RawNode n3 = RawNode.createNode("3");
        n1.addNext(n2).addNext(n3);
        RawNode n4 = RawNode.createNode("4");
        // TODO: Create three nodes, n1, n2 and n3, add them into a three nodes list
        // TODO: then create a fourth node n, adding it to the tail of the list pointed by n1.
        // TODO: verify n links are pointing to n3 and null, while n3 next link is now pointing to n.
        n1.addTail(n4);
        assertEquals(n3, n4.getPrev());
        assertNull(n4.getNext());
    }
}
