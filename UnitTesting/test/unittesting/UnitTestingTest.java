/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Summer
 */
public class UnitTestingTest {
    
    public UnitTestingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class UnitTesting.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        UnitTesting.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of concatenate method, of class UnitTesting.
     */
    @Test
    public void testConcatenate() {
        System.out.println("concatenate");
        String one = "race";
        String two = "car";
        UnitTesting instance = new UnitTesting();
        String expResult = "racecar";
        String result = instance.concatenate(one, two);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
