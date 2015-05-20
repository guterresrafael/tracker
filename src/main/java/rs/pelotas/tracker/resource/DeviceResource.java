package rs.pelotas.tracker.resource;

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
import rs.pelotas.arch.resource.Resource;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.security.role.DeviceRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.DEVICES)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface DeviceResource extends Resource<Device, Long> {
    
    @RolesAllowed({DeviceRole.LIST})
    @AddLinks
    @LinkResource(Device.class)
    @GET
    @Path("/")
    @Override
    public List<Device> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({DeviceRole.CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    public Response postEntity(Device entity);
    
    @RolesAllowed({DeviceRole.READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public Device getEntityById(@PathParam("id") Long id);

    @RolesAllowed({DeviceRole.UPDATE})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    public Response putEntity(@PathParam("id") Long id, Device entity);

    @RolesAllowed({DeviceRole.DELETE})
    @LinkResource(Device.class)
    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEntity(@PathParam("id") Long id);
    
    @RolesAllowed({DeviceRole.USERS_LIST})
    @AddLinks
    @LinkResource(value = Device.class, rel = "users")
    @GET
    @Path("/{id}/users")
    public Collection<Device> getUsers(@PathParam("id") Long deviceId);
}