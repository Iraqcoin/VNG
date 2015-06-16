/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angle.junit;

import com.oo.reader.ReadExcel;
import java.io.IOException;
import java.util.Collection;
import static org.hamcrest.Matchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.runners.Parameterized;

/**
 *
 * @author hoaibao
 */
@RunWith(Parameterized.class)
public class MyAgileTestTest {

    private double numberOfTweets;
    private double expectedFee;

    @Parameters
    public static Collection data() throws IOException {
        return new ReadExcel("/home/hoaibao/lars.xls",0).read();
    }

    public MyAgileTestTest(double numberOfTweets, double expectedFee) {
        super();
        this.numberOfTweets = numberOfTweets;
        this.expectedFee = expectedFee;
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
     * Test of add method, of class MyAgileTest.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        MyAgileTest instance = new MyAgileTest();
        double result = instance.add(this.numberOfTweets);
        assertThat(result, is(expectedFee));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
       // assertEquals("OK", expectedFee, result, 0);
    }
   @Test
    public void testSub() {
        System.out.println("sub");
        MyAgileTest instance = new MyAgileTest();
        double result = instance.sub(this.numberOfTweets);
        assertThat(result, is(expectedFee));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
       // assertEquals("OK", expectedFee, result, 0);
    }
}
