/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author W9336459
 */
public class ChairTest {
    
    public ChairTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getArmRest method, of class Chair.
     */
    @Test
    public void testGetArmRest() {
        System.out.println("getArmRest");
        Chair instance = new Chair();
        boolean expResult = false;
        boolean result = instance.getArmRest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Chair.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Chair instance = new Chair();
        double expResult = 4875;
        double result = instance.getPrice();
        assertEquals(expResult, result, 4875);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class Chair.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        Chair instance = new Chair();
        String[] expResult = null;
        String[] result = instance.getValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setArmRest method, of class Chair.
     */
    @Test
    public void testSetArmRest() {
        System.out.println("setArmRest");
        boolean armRest = false;
        Chair instance = new Chair();
        instance.setArmRest(armRest);
       //  assertEquals(instance, armRest);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Chair.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double finalPrice = 5432;
        Chair instance = new Chair();
        instance.setPrice(finalPrice);
        
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Chair.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Chair instance = new Chair();
        String expResult = "/ Id Num :0,\n\tType Of Wood   :W,\n\tArm Rest       :false,\n\tPrice          :£48.75, \n?";
        String result = instance.toString();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//     //   fail("The test case is a prototype.");
    }
    
}
