package tracker.domain.resource;

import javax.annotation.security.DenyAll;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tracker.core.resource.BaseResource;
import tracker.domain.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource extends BaseResource<User, Long> {
    
    @DenyAll
    @Override
    public Response deleteEntity(Long id);
}