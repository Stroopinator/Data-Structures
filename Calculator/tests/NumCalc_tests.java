package Calculator.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import Calculator.main.NumCalc;
import Calculator.main.OpNode;

public class NumCalc_tests {

    @Test
    public void test_evaluate() throws Exception {
        NumCalc myCalc = new NumCalc();
        // TODO: Create a numerical calculator object and use it to evaluate
        // TODO: a few valid expressions, given as string (i.e "2 ^ 3 + 5 * 7")
        // TODO: Verify the resulting string matches the expected result.
        assertEquals("43.0", myCalc.evaluate("2 ^ 3 + 5 * 7"));
        // TODO: Use the same instance to evaluate some invalid expressions (i.e. "1 + / 3")
        // TODO: Use try..catch blocks to verify the expected exception.
    }
    
    @Test
    public void test_evaluationTrace() throws Exception {
        // TODO: Create a numerical calculator object and use it t
        NumCalc myCalc = new NumCalc();
        // TODO: a more complex expression (i.e: "4 * 8 - 6 / 3 ^ 0 + 7 % 5 * -2.4").
        // TODO: Build a multi-line string containing the expected evaluation trace.
        // TODO: and verify the string returned by the calculator's toString() method
        // TODO: matches the expected evaluation trace.
        myCalc.evaluate("2 ^ 3 + 5 * 7");
        String s = "2 ^ 3 + 5 * 7\n" +  
        "8.0 + 5 * 7\n" + 
        "8.0 + 35.0\n" + 
        "43.0\n";
        assertEquals(s, myCalc.toString());
        
    }
    
}
