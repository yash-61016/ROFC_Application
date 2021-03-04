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
public class TableTest {
    
    public TableTest() {
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
     * Test of getDiameter method, of class Table.
     */
    @Test
    public void testGetDiameter() {
        System.out.println("getDiameter");
        Table instance = new Table();
        double expResult = 0.0;
        double result = instance.getDiameter();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseType method, of class Table.
     */
    @Test
    public void testGetBaseType() {
        System.out.println("getBaseType");
        Table instance = new Table();
        char expResult = 'C';
        char result = instance.getBaseType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Table.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Table instance = new Table();
        double expResult = 3500;
        double result = instance.getPrice();
        assertEquals(expResult, result, 3500);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class Table.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        Table instance = new Table();
        String[] expResult = null;
        String[] result = instance.getValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Table.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Table instance = new Table();
        String expResult = "/ Id Num :0,\n\tType Of Wood   :W,\n\tDiameter       :0.0,\n\tBase Type      :C,\n\tPrice          :£0.00, \n?";
        String result = instance.toString();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
