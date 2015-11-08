package tracker.resource;

import arch.resource.Resource;
import arch.security.role.AdminRole;
import java.util.Collection;
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
import tracker.security.role.DeviceRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.DEVICES)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface DeviceResource extends Resource<Device, Long> {

    @RolesAllowed({AdminRole.LIST, DeviceRole.LIST})
    @AddLinks
    @LinkResource(Device.class)
    @GET
    @Path("/")
    @Override
    List<Device> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({AdminRole.CREATE, DeviceRole.CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    Response postEntity(Device entity);

    @RolesAllowed({AdminRole.READ, DeviceRole.READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    Device getEntityById(@PathParam("id") Long id);

    @RolesAllowed({AdminRole.UPDATE, DeviceRole.UPDATE})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    Response putEntity(@PathParam("id") Long id, Device entity);

    @RolesAllowed({AdminRole.DELETE, DeviceRole.DELETE})
    @LinkResource(Device.class)
    @DELETE
    @Path("/{id}")
    @Override
    Response deleteEntity(@PathParam("id") Long id);

    @RolesAllowed({AdminRole.READ, DeviceRole.USERS_LIST})
    @AddLinks
    @LinkResource(value = Device.class, rel = "users")
    @GET
    @Path("/{id}/users")
    Collection<User> getUsers(@PathParam("id") Long deviceId);
}
