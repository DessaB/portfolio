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
public class OrderTest {
    
    public OrderTest() {
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
     * Test of getOrderNumber method, of class Order.
     */
    @Test
    public void testGetOrderNumber() {
        System.out.println("getOrderNumber");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerName method, of class Order.
     */
    @Test
    public void testGetCustomerName() {
        System.out.println("getCustomerName");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getCustomerName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerName method, of class Order.
     */
    @Test
    public void testSetCustomerName() {
        System.out.println("setCustomerName");
        String customerName = "";
        Order instance = new Order();
        instance.setCustomerName(customerName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Order.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class Order.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String state = "";
        Order instance = new Order();
        instance.setState(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductType method, of class Order.
     */
    @Test
    public void testGetProductType() {
        System.out.println("getProductType");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getProductType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductType method, of class Order.
     */
    @Test
    public void testSetProductType() {
        System.out.println("setProductType");
        String productType = "";
        Order instance = new Order();
        instance.setProductType(productType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Order.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Order instance = new Order();
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Order.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        Order instance = new Order();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArea method, of class Order.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getArea();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArea method, of class Order.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        double area = 0.0;
        Order instance = new Order();
        instance.setArea(area);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCostPerSqFt method, of class Order.
     */
    @Test
    public void testGetCostPerSqFt() {
        System.out.println("getCostPerSqFt");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getCostPerSqFt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCostPerSqFt method, of class Order.
     */
    @Test
    public void testSetCostPerSqFt() {
        System.out.println("setCostPerSqFt");
        double costPerSqFt = 0.0;
        Order instance = new Order();
        instance.setCostPerSqFt(costPerSqFt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaborCostPerSqFt method, of class Order.
     */
    @Test
    public void testGetLaborCostPerSqFt() {
        System.out.println("getLaborCostPerSqFt");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getLaborCostPerSqFt();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLaborCostPerSqFt method, of class Order.
     */
    @Test
    public void testSetLaborCostPerSqFt() {
        System.out.println("setLaborCostPerSqFt");
        double laborCostPerSqFt = 0.0;
        Order instance = new Order();
        instance.setLaborCostPerSqFt(laborCostPerSqFt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaxRate method, of class Order.
     */
    @Test
    public void testGetTaxRate() {
        System.out.println("getTaxRate");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getTaxRate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaxRate method, of class Order.
     */
    @Test
    public void testSetTaxRate() {
        System.out.println("setTaxRate");
        double taxRate = 0.0;
        Order instance = new Order();
        instance.setTaxRate(taxRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterialCost method, of class Order.
     */
    @Test
    public void testGetMaterialCost() {
        System.out.println("getMaterialCost");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getMaterialCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaborCost method, of class Order.
     */
    @Test
    public void testGetLaborCost() {
        System.out.println("getLaborCost");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getLaborCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTax method, of class Order.
     */
    @Test
    public void testGetTax() {
        System.out.println("getTax");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getTax();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Order.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubtotal method, of class Order.
     */
    @Test
    public void testGetSubtotal() {
        System.out.println("getSubtotal");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.getSubtotal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Order instance = new Order();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
