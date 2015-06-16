/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common.Provider;

import Common.ThriftInterface.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoaibao
 */
public class UserHandlerTest {
    
    public UserHandlerTest() {
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
     * Test of GetUser method, of class UserHandler.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("GetUser");
        String username = "";
        UserHandler instance = new UserHandler();
        User expResult = null;
        User result = instance.GetUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateVisitor method, of class UserHandler.
     */
    @Test
    public void testUpdateVisitor() throws Exception {
        System.out.println("UpdateVisitor");
        String username = "";
        UserHandler instance = new UserHandler();
        int expResult = 0;
        int result = instance.UpdateVisitor(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Increase method, of class UserHandler.
     */
    @Test
    public void testIncrease() throws Exception {
        System.out.println("Increase");
        String username = "";
        UserHandler instance = new UserHandler();
        User expResult = null;
        User result = instance.Increase(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckLogin method, of class UserHandler.
     */
    @Test
    
    public void testCheckLogin() throws Exception {
        System.out.println("CheckLogin");
        String username = "";
        String pword = "";
        UserHandler instance = new UserHandler();
        boolean expResult = false;
        boolean result = instance.CheckLogin(username, pword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
