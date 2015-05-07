package rs.pelotas.tracker.resource;

import java.util.Collection;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Path("/commands")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface CommandResource extends BaseResource<Command, Long> {

    @PermitAll
    @AddLinks
    @LinkResource(Command.class)
    @GET
    @Path("/")
    @Override
    public Collection<Command> getEntities(@Context HttpServletRequest request);
    
    @PermitAll
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public Command getEntityById(@PathParam("id") Long id);
}