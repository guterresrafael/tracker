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
import tracker.entity.Position;
import tracker.security.role.PositionRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.POSITIONS)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface PositionResource extends Resource<Position, Long> {

    @RolesAllowed({AdminRole.LIST, PositionRole.LIST})
    @AddLinks
    @LinkResource(Position.class)
    @GET
    @Path("/")
    @Override
    List<Position> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({AdminRole.CREATE, PositionRole.CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    Response postEntity(Position entity);

    @RolesAllowed({AdminRole.READ, PositionRole.READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    Position getEntityById(@PathParam("id") Long id);

    @RolesAllowed({AdminRole.UPDATE, PositionRole.UPDATE})
    @AddLinks
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    Response putEntity(@PathParam("id") Long id, Position entity);

    @RolesAllowed({AdminRole.DELETE, PositionRole.DELETE})
    @LinkResource(Position.class)
    @DELETE
    @Path("/{id}")
    @Override
    Response deleteEntity(@PathParam("id") Long id);

    @RolesAllowed({AdminRole.READ, PositionRole.READ})
    @LinkResource(value = Position.class, rel = "googlemaps")
    @GET
    @Path("/{id}/googlemaps")
    Response getGoogleMapsLink(@PathParam("id") Long id);
}
