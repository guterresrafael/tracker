package tracker.domain.resource;

import javax.annotation.security.DenyAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import tracker.core.resource.BaseResource;
import tracker.domain.entity.User;

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