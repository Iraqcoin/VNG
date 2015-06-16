/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewcount.unittest;

import Common.ThriftInterface.User;
import Common.ThriftInterface.UserService;
import com.oo.reader.ReadExcel;
import java.io.IOException;
import java.util.Collection;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import static org.hamcrest.Matchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author hoaibao
 */
@RunWith(Parameterized.class)
public class ApiGetTest {

    private String username;
    private String expected;

    @Parameterized.Parameters
    public static Collection data() throws IOException {
        return new ReadExcel("/home/hoaibao/testcase.xls", 0).read();
    }

    public ApiGetTest(String username, String expected) {
        super();
        this.username = username;
        this.expected = expected;
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

    @Test
    public void testGetUser() {
        System.out.println("GET");
        TTransport transport = null;
        UserService.Client client = null;
        try {
            transport = new TFramedTransport(new TSocket("localhost", 9090));//Nonlocking Server
            //transport = new TSocket("localhost", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new UserService.Client(protocol);
            User u = client.GetUser(this.username);
            if (u.getUsername() == null) {
                Assert.assertNull(u.getUsername());
                return;
            }
            assertThat(u.getUsername(), is(this.expected));
            //fail("The test case is a prototype.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transport.close();
        }
    }
    
    
}
