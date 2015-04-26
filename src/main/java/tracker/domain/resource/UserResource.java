package tracker.domain.resource;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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