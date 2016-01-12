/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class OrderBookTest {
    public OrderBookTest() {
     
       
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
     * Test of displayOrder method, of class OrderBook.
     */
    @Test
    public void testDisplayOrder() {
        System.out.println("displayOrder");
        String key = "";
        OrderBook instance = new OrderBook();
        String expResult = "";
        String result = instance.displayOrdersByDate(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class OrderBook.
     */
    @Test
    public void testGetOrder() {
        OrderBook book = new OrderBook();
        book.addOrder(".", ".", ".", 0.0);
        System.out.println("getOrder");
        String key = "010120000";
        //OrderBook instance = new OrderBook();
        Order expResult = null;
        Order result = book.getOrder(key);
        assertEquals(expResult, result);
        System.out.println(expResult + " " + result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addOrder method, of class OrderBook.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        String name = "";
        String state = "";
        String product = "";
        double area = 0.0;
        OrderBook instance = new OrderBook();
        instance.addOrder(name, state, product, area);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editOrder method, of class OrderBook.
     */
    @Test
    public void testEditOrder() {
        System.out.println("editOrder");
        String key = "";
        OrderBook instance = new OrderBook();
        Order expResult = null;
        Order result = instance.editOrder(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrder method, of class OrderBook.
     */
    //@Test
    /*public void testRemoveOrder() {
        System.out.println("removeOrder");
        String key = "";
        OrderBook instance = new OrderBook();
        boolean expResult = false;
        //boolean result = instance.removeOrder(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    //}
    
}
