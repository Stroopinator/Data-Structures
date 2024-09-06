package Calculator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import Calculator.main.NumNode;

public class NumNode_tests {

    @Test
    public void test_createNode() {
        // TODO: Create a few numerical nodes with various correct numerical values given strings
        NumNode n1 = NumNode.createNode("1");
        NumNode n2 = NumNode.createNode("2");
        NumNode n3 = NumNode.createNode("-1");
        NumNode n4 = NumNode.createNode("0");
        // TODO: and verify they reflect their content correctly as a double value.
        assertEquals(1.0, n1.getNumValue(),0.00000001);
        assertEquals(2.0, n2.getNumValue(),0.00000001);
        assertEquals(-1.0, n3.getNumValue(),0.00000001);
        assertEquals(0, n4.getNumValue(),0.00000001);
        // TODO: Try create a numerical node with an invalid string and
        NumNode n5 = NumNode.createNode("hello");
        assertNull(n5);
        // TODO: verify the result is a null reference.
    }

}
