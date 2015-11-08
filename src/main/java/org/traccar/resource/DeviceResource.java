package org.traccar.resource;

import arch.resource.Resource;
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
import org.traccar.entity.Device;
import tracker.security.role.TraccarRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.TRACCAR_DEVICES)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface DeviceResource extends Resource<Device, Long> {

    @RolesAllowed({TraccarRole.DEVICES_LIST})
    @AddLinks
    @LinkResource(Device.class)
    @GET
    @Path("/")
    @Override
    List<Device> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({TraccarRole.DEVICES_CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    Response postEntity(Device entity);

    @RolesAllowed({TraccarRole.DEVICES_READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    Device getEntityById(@PathParam("id") Long id);

    @RolesAllowed({TraccarRole.DEVICES_UPDATE})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    Response putEntity(@PathParam("id") Long id, Device entity);

    @RolesAllowed({TraccarRole.DEVICES_DELETE})
    @LinkResource(Device.class)
    @DELETE
    @Path("/{id}")
    @Override
    Response deleteEntity(@PathParam("id") Long id);

    @RolesAllowed({TraccarRole.DEVICES_USERS_LIST})
    @AddLinks
    @LinkResource(value = Device.class, rel = "users")
    @GET
    @Path("/{id}/users")
    Collection<Device> getUsers(@PathParam("id") Long deviceId);
}
