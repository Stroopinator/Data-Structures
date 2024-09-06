package UnitTestProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CargoPlaneTests {
    private CargoPlane myObj;

    @Before
    public void setupTests() {
        System.out.println("Before");
        myObj = new CargoPlane(13, 40);
    }

    @Test
    public void testConstructor() {
        System.out.println("testConstructor");
        System.out.println(myObj.getFuel());
        System.out.println(myObj.getBoxes());
        // verify the value produced from getFuel is 13
        // verify the value produced from getBoxes is 40
        assertEquals(13, myObj.getFuel());
        assertEquals(40, myObj.getBoxes());

    }

    @Test
    public void testMutator() {
        System.out.println("testMutator");
        myObj.refuel(15);
        myObj.addBoxes(15);
        assertEquals(28, myObj.getFuel());
        assertEquals(55, myObj.getBoxes());
        myObj.deFule(15);
        myObj.removeBoxes(15);
        assertEquals(13, myObj.getFuel());
        assertEquals(40, myObj.getBoxes());
    }

    @Test
    public void testIsValid() {
        System.out.println("testIsLavid");
        System.out.println(myObj.isValid());
        assertTrue(myObj.isValid());
        myObj.deFule(100);
        myObj.removeBoxes(100);
        assertEquals(false, myObj.isValid());

    }
}
