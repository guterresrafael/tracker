package tracker.core.annotation;

import rs.pelotas.arch.helper.Assembler;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.to.UserTO;

/**
 *
 * @author Rafael Guterres
 */
public class AssemblerTest {
    
    public AssemblerTest() {
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
     public void simpleAssemblerUserTest() {
         User user = new User();
         user.setId(1L);
         user.setLogin("login");
         user.setPassword("password");
         UserTO userTO = new UserTO();
         Assembler.assembler(user, userTO);
         assertEquals(userTO.getId(), user.getId());
         assertEquals(userTO.getLogin(), user.getLogin());
         assertEquals(userTO.getPassword(), user.getPassword());
     }
     
     @Test
     public void hello() {
         assertTrue(true);
     }
}
