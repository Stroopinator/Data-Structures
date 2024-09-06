package Mountains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class MountainTests {
    private Mountain testMountain;
    
    @Before
    public void setupTests(){
        String line = "America	Mountain	Rainier	90.0	87.3	1340ft";
        testMountain = new Mountain(line);  
        System.out.println(testMountain.getCountry() + "\t" + testMountain.getName() + "\t" + testMountain.getLat() + "\t" + 
        testMountain.getLong() + "\t" + testMountain.getElevation() + "\t" + testMountain.getUnits()+"\n");
            
    }
    @Test
    public void testConstructor(){
        System.out.println("test Constructor");
        assertEquals(testMountain.getCountry(), "America");
        assertEquals(testMountain.getName(), "Rainier");
        assertEquals(90.0, testMountain.getLat(),0);
        assertEquals(testMountain.getLong(), 87.3,0);
        assertEquals((double)1340/3, testMountain.getElevation(),.000001);
        assertEquals(testMountain.getUnits(), "m");
        //this time we will give it an invalid line seperated with spaces instead of tabs this should return true.
        String line = "America	Mountain Rainier	82.3	-28.4	1340m";
        testMountain = new Mountain(line);
        assertTrue(testMountain.getHasError());
        assertEquals("record is not valid", testMountain.getErrorMessages());
        //this test will check whether the mountain will get the right elevation and units if it is in meters
        line = "America	Mountain	Rainier	82.3	-28.4	1340m";
        testMountain = new Mountain(line);
        System.out.println(testMountain.getElevation()+"" +"elevation");
        assertEquals(1340, testMountain.getElevation(),0);
        assertEquals("m", testMountain.getUnits());
    }
    @Test
    public void testLatitudeAndLongitude(){
        //tests whether valid coordinates are considered valid
        String line = "America	Mountain	Rainier	160.0	87.3	1340ft";
        testMountain = new Mountain(line);
        //assertFalse(testMountain.getHasError());
        //This time we will give it both invalid latitude and longitude
        line = "America	Mountain	Rainier	90.1	-180.1	1340ft";
        testMountain = new Mountain(line);
        assertTrue(testMountain.getHasError());
        assertEquals("Latitude is off the earth Longitude is off the earth ", testMountain.getErrorMessages());
        line = "America	Mountain	Rainier	90.0	-180.1	1340ft";
        testMountain = new Mountain(line);
        assertTrue(testMountain.getHasError());
        assertEquals("Longitude is off the earth ", testMountain.getErrorMessages());
        line = "America	Mountain	Rainier	90.1	-180.0	1340ft";
        testMountain = new Mountain(line);
        assertTrue(testMountain.getHasError());
        assertEquals("Latitude is off the earth ", testMountain.getErrorMessages());
        
    }
    @Test
    public void testUnits(){
        String line = "America	Mountain	Rainier	0.0	0.0	1340ft";
        testMountain = new Mountain(line);
        assertEquals("m", testMountain.getUnits());
        assertEquals((double)1340/3, testMountain.getElevation(),0);
        line = "America	Mountain	Rainier	11.7	87.3	1340m";
        testMountain = new Mountain(line);
        assertEquals("m", testMountain.getUnits());
        assertEquals(1340, testMountain.getElevation(),0);
        line = "America	Mountain	Rainier	16.3	87.3	1340";
        testMountain = new Mountain(line);
        assertEquals(1340, testMountain.getElevation(),0);
        assertEquals("m", testMountain.getUnits());

    }

}
