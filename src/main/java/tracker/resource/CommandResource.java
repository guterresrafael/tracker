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
import tracker.entity.Command;
import tracker.security.role.CommandRole;

/**
 *
 * @author Rafael Guterres
 */
@Path(AppResourcePath.COMMANDS)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface CommandResource extends Resource<Command, Long> {

    @RolesAllowed({AdminRole.LIST, CommandRole.LIST})
    @AddLinks
    @LinkResource(value = Command.class)
    @GET
    @Path("/")
    @Override
    List<Command> getEntities(@Context HttpServletRequest request);

    @RolesAllowed({AdminRole.CREATE, CommandRole.CREATE})
    @LinkResource
    @POST
    @Path("/")
    @Override
    Response postEntity(Command entity);

    @RolesAllowed({AdminRole.READ, CommandRole.READ})
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    Command getEntityById(@PathParam("id") Long id);

    @RolesAllowed({AdminRole.UPDATE, CommandRole.UPDATE})
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    Response putEntity(@PathParam("id") Long id, Command entity);

    @RolesAllowed({AdminRole.DELETE, CommandRole.DELETE})
    @LinkResource(value = Command.class)
    @DELETE
    @Path("/{id}")
    @Override
    Response deleteEntity(@PathParam("id") Long id);
}
