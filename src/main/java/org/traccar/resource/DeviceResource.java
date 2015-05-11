package org.traccar.resource;

import java.util.Collection;
import javax.annotation.security.PermitAll;
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
@Path("/devices")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface DeviceResource extends Resource<Device, Long> {
    
    @PermitAll
    @AddLinks
    @LinkResource(Device.class)
    @GET
    @Path("/")
    @Override
    public Collection<Device> getEntities(@Context HttpServletRequest request);

    @PermitAll
    @LinkResource
    @POST
    @Path("/")
    @Override
    public Response postEntity(Device entity);
    
    @PermitAll
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public Device getEntityById(@PathParam("id") Long id);

    @PermitAll
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    public Response putEntity(@PathParam("id") Long id, Device entity);

    @PermitAll
    @LinkResource(Device.class)
    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEntity(@PathParam("id") Long id);
    
    @PermitAll
    @AddLinks
    @LinkResource(value = Device.class, rel = "users")
    @GET
    @Path("/{id}/users")
    public Collection<Device> getUsers(@PathParam("id") Long deviceId);
}
