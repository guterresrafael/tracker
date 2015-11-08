package tracker.core.annotation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.traccar.entity.User;

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

    //@Test
     public void simpleAssemblerUserTest() {
         User user = new User();
         user.setId(1L);
         user.setLogin("login");
         user.setPassword("password");
//         UserTO userTO = new UserTO();
//         Assembler.assembler(user, userTO);
//         assertEquals(userTO.getId(), user.getId());
//         assertEquals(userTO.getLogin(), user.getLogin());
//         assertEquals(userTO.getPassword(), user.getPassword());
     }
     
     //@Test
     public void hello() {
         assertTrue(true);
     }
}
