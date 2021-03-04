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
public class FurnitureTest {
    
    public FurnitureTest() {
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
     * Test of getIdNum method, of class Furniture.
     */
    @Test
    public void testGetIdNum() {
        System.out.println("getIdNum");
        Furniture instance = new FurnitureImpl();
        int expResult = 0;
        int result = instance.getIdNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeOfWood method, of class Furniture.
     */
    @Test
    public void testGetTypeOfWood() {
        System.out.println("getTypeOfWood");
        Furniture instance = new FurnitureImpl();
        int expResult = 'W';
        int result = instance.getTypeOfWood();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Furniture.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Furniture instance = new FurnitureImpl();
        int expResult = 1;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class Furniture.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        Furniture instance = new FurnitureImpl();
        String[] expResult = null;
        String[] result = instance.getValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setIdNum method, of class Furniture.
     */
    @Test
    public void testSetIdNum() {
        System.out.println("setIdNum");
        int idNum = 101;
        Furniture instance = new FurnitureImpl();
        instance.setIdNum(idNum);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setTypeOfWood method, of class Furniture.
     */
    @Test
    public void testSetTypeOfWood() {
        System.out.println("setTypeOfWood");
        char typeOfWood = 'W';
        Furniture instance = new FurnitureImpl();
        instance.setTypeOfWood(typeOfWood);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class Furniture.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        Furniture instance = new FurnitureImpl();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Furniture.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Furniture instance = new FurnitureImpl();
        String expResult = "/ Id Num :0,\n\tType Of Wood   :W,\n\t";
        String result = instance.toString();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//      //  fail("The test case is a prototype.");
    }

    public class FurnitureImpl extends Furniture {
    }
    
}
