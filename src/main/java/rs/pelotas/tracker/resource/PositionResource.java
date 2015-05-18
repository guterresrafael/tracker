package rs.pelotas.tracker.resource;

import java.util.List;
import javax.annotation.security.PermitAll;
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
import rs.pelotas.tracker.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
@Path("/positions")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface PositionResource extends Resource<Position, Long> {

    @RolesAllowed("admin")
    @AddLinks
    @LinkResource(Position.class)
    @GET
    @Path("/")
    @Override
    public List<Position> getEntities(@Context HttpServletRequest request);

    @RolesAllowed("admin")
    @LinkResource
    @POST
    @Path("/")
    @Override
    public Response postEntity(Position entity);

    @RolesAllowed("admin")
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public Position getEntityById(@PathParam("id") Long id);
    
    @RolesAllowed("admin")
    @AddLinks
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    public Response putEntity(@PathParam("id") Long id, Position entity);

    @RolesAllowed("admin")
    @LinkResource(Position.class)
    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEntity(@PathParam("id") Long id);
    
    @RolesAllowed("admin")
    @LinkResource(value = Position.class, rel = "googlemaps")
    @GET
    @Path("/{id}/googlemaps")
    public Response getGoogleMapsLink(@PathParam("id") Long id);
}