package rs.pelotas.tracker.resource;

import javax.annotation.security.DenyAll;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Path("/users")
public interface UserResource extends BaseResource<User, Long> {
    
    @DenyAll
    @Override
    public Response deleteEntity(Long id);
}