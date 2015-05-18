package org.traccar.resource;

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
import org.traccar.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
@Path("/traccar/devices")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface DeviceResource extends Resource<Device, Long> {
    
    @RolesAllowed({"traccar_admin", "traccar_admin_read"})
    @AddLinks
    @LinkResource(Device.class)
    @GET
    @Path("/")
    @Override
    public List<Device> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({"traccar_admin", "traccar_admin_create"})
    @LinkResource
    @POST
    @Path("/")
    @Override
    public Response postEntity(Device entity);
    
    @RolesAllowed({"traccar_admin", "traccar_admin_read"})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public Device getEntityById(@PathParam("id") Long id);

    @RolesAllowed({"traccar_admin", "traccar_admin_update"})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    public Response putEntity(@PathParam("id") Long id, Device entity);

    @RolesAllowed({"traccar_admin", "traccar_admin_delete"})
    @LinkResource(Device.class)
    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEntity(@PathParam("id") Long id);
    
    @RolesAllowed({"traccar_admin", "traccar_admin_read_users"})
    @AddLinks
    @LinkResource(value = Device.class, rel = "users")
    @GET
    @Path("/{id}/users")
    public Collection<Device> getUsers(@PathParam("id") Long deviceId);
}
