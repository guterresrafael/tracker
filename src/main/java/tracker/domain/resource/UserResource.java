package tracker.domain.resource;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import tracker.domain.entity.User;
import tracker.domain.filter.UserFilter;
import tracker.domain.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
@Path("/users")
public class UserResource {
    
    @Inject
    UserService userService;

    @PermitAll
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            //TODO: Implementar NotFound;
        }
        return users;
    }
    
    @PermitAll
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id) {
        User user = userService.load(id);
        if (user == null) {
            //TODO: Implementar NotFound
        }
        return user;
    }
    
    @PermitAll
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsersByFilter(@QueryParam("login") String login) {
        UserFilter userFilter = new UserFilter();
        userFilter.setLogin(login);
        List<User> users = userService.findByFilter(userFilter);
        if (users.isEmpty()) {
            //TODO: Implementar NotFound
        }
        return users;
    }
}
