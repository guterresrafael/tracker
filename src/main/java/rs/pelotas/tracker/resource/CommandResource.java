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
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.security.role.CommandRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.COMMANDS)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface CommandResource extends Resource<Command, Long> {

    @RolesAllowed({CommandRole.LIST})
    @AddLinks
    @LinkResource(value = Command.class)
    @GET
    @Path("/")
    @Override
    public List<Command> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({CommandRole.CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    public Response postEntity(Command entity);
    
    @RolesAllowed({CommandRole.READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public Command getEntityById(@PathParam("id") Long id);

    @RolesAllowed({CommandRole.UPDATE})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    public Response putEntity(@PathParam("id") Long id, Command entity);

    @RolesAllowed({CommandRole.DELETE})
    @LinkResource(value = Command.class)
    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEntity(@PathParam("id") Long id);    
}