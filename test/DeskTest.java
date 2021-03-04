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
public class DeskTest {
    
    public DeskTest() {
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
     * Test of getWidth method, of class Desk.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Desk instance = new Desk();
        double expResult = 0.0;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getDepth method, of class Desk.
     */
    @Test
    public void testGetDepth() {
        System.out.println("getDepth");
        Desk instance = new Desk();
        double expResult = 0.0;
        double result = instance.getDepth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getNumOfDrawers method, of class Desk.
     */
    @Test
    public void testGetNumOfDrawers() {
        System.out.println("getNumOfDrawers");
        Desk instance = new Desk();
        int expResult = 1;
        int result = instance.getNumOfDrawers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Desk.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Desk instance = new Desk();
        double expResult = 1810;
        double result = instance.getPrice();
        assertEquals(expResult, result, 1810);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class Desk.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        Desk instance = new Desk();
        String[] expResult = null;
        String[] result = instance.getValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Desk.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Desk instance = new Desk();
        String expResult = "/ Id Num :0,\n\tType Of Wood   :W,\n\tWidth          :0.0,\n\tDepth          :0.0,\n\tNum Of Drawers :1,\n\tPrice          :£0.00, \n?";
        String result = instance.toString();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
