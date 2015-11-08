package tracker.resource;

import arch.resource.Resource;
import arch.security.role.AdminRole;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import tracker.entity.Device;
import tracker.entity.User;
import tracker.security.role.UserRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.USERS)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface UserResource extends Resource<User, Long> {

    @RolesAllowed({AdminRole.LIST})
    @AddLinks
    @LinkResource(User.class)
    @GET
    @Path("/")
    @Override
    List<User> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({AdminRole.CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    Response postEntity(User entity);

    @RolesAllowed({AdminRole.READ, UserRole.READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    User getEntityById(@PathParam("id") Long id);

    @RolesAllowed({AdminRole.UPDATE, UserRole.UPDATE})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    Response putEntity(@PathParam("id") Long id, User entity);

    @RolesAllowed({AdminRole.DELETE, UserRole.DELETE})
    @LinkResource(User.class)
    @DELETE
    @Path("/{id}")
    @Override
    Response deleteEntity(@PathParam("id") Long id);

    @RolesAllowed({AdminRole.LIST, UserRole.DEVICES_LIST})
    @AddLinks
    @LinkResource(value = User.class, rel = "devices")
    @GET
    @Path("/{id}/devices")
    List<Device> getDevices(@PathParam("id") Long userId);
}
