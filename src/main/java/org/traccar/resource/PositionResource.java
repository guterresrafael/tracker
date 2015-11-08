package org.traccar.resource;

import arch.resource.Resource;
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
import org.traccar.entity.Position;
import tracker.security.role.TraccarRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.TRACCAR_POSITIONS)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface PositionResource extends Resource<Position, Long> {

    @RolesAllowed({TraccarRole.POSITIONS_LIST})
    @AddLinks
    @LinkResource(Position.class)
    @GET
    @Path("/")
    @Override
    List<Position> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({TraccarRole.POSITIONS_CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    Response postEntity(Position entity);

    @RolesAllowed({TraccarRole.POSITIONS_READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    Position getEntityById(@PathParam("id") Long id);

    @RolesAllowed({TraccarRole.POSITIONS_UPDATE})
    @AddLinks
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    Response putEntity(@PathParam("id") Long id, Position entity);

    @RolesAllowed({TraccarRole.POSITIONS_DELETE})
    @LinkResource(Position.class)
    @DELETE
    @Path("/{id}")
    @Override
    Response deleteEntity(@PathParam("id") Long id);

    @RolesAllowed({TraccarRole.POSITIONS_READ})
    @LinkResource(value = Position.class, rel = "googlemaps")
    @GET
    @Path("/{id}/googlemaps")
    Response getGoogleMapsLink(@PathParam("id") Long id);
}
