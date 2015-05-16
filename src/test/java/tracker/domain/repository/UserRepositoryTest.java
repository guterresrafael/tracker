package tracker.domain.repository;

import java.util.logging.Level;
import static org.junit.Assert.assertNotNull;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import rs.pelotas.arch.core.Resources;
import org.traccar.entity.User;
import org.traccar.service.UserService;

//@RunWith(Arquillian.class)
public class UserRepositoryTest {

    //@Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Resources.class, User.class, UserService.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-datasource.xml");
    }

    //@Inject
    UserService userService;

    //@Inject
    Logger logger;

    //@Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setLogin("guterres");
        user.setPassword("123mudar");
        userService.save(user);
        assertNotNull(user.getId());
        logger.log(Level.INFO, "{0} was persisted with id {1}", new Object[]{user.getLogin(), user.getId()});
    }
}
