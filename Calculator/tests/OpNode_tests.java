package Calculator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import Calculator.main.NumNode;
import Calculator.main.OpNode;
import Calculator.main.OpNode.OpCode;

public class OpNode_tests {

    @Test
    public void test_createNode() {
        // TODO: Create OpNodes for each of the supported operators (i.e. "+",..)
        OpNode n1 = OpNode.createNode("+");
        OpNode n2 = OpNode.createNode("-");
        OpNode n3 = OpNode.createNode("*");
        OpNode n4 = OpNode.createNode("/");
        OpNode n5 = OpNode.createNode("%");
        OpNode n6 = OpNode.createNode("^");
        // TODO: and verify they reflect back the the correct operator code (i.e. OpCode.ADDITION)
        assertEquals(OpCode.ADDITION, n1.getOpCode());
        assertEquals(OpCode.SUBTRACTION, n2.getOpCode());
        assertEquals(OpCode.MULTIPLICATION, n3.getOpCode());
        assertEquals(OpCode.DIVISION, n4.getOpCode());
        assertEquals(OpCode.MODULO, n5.getOpCode());
        assertEquals(OpCode.POWER, n6.getOpCode());
    }
    
    @Test
    public void test_evaluate() throws Exception {
        // TODO: Create a valid sequence of NumNode, OpNode, NumNode, chain them in a linked list
        NumNode n1 = NumNode.createNode("2");
        OpNode o1 = OpNode.createNode("+");
        NumNode n2 = NumNode.createNode("3");
        n1.addNext(o1).addNext(n2);
        double value = o1.evaluate().getNumValue();
        assertEquals(5, value,0.0000001);
        // TODO: And verify the result of the evaluation of the operator node is as expected.
    }
}
