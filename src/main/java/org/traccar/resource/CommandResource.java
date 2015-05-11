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
import org.traccar.entity.Command;

/**
 *
 * @author Rafael Guterres
 */
@Path("/traccar/commands")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface CommandResource extends Resource<Command, Long> {

    @PermitAll
    @AddLinks
    @LinkResource(value = Command.class)
    @GET
    @Path("/")
    @Override
    public Collection<Command> getEntities(@Context HttpServletRequest request);

    @PermitAll
    @LinkResource
    @POST
    @Path("/")
    @Override
    public Response postEntity(Command entity);
    
    @PermitAll
    @AddLinks
    @LinkResource
    @GET
    @Path("/{id}")
    @Override
    public Command getEntityById(@PathParam("id") Long id);

    @PermitAll
    @LinkResource
    @PUT
    @Path("/{id}")
    @Override
    public Response putEntity(@PathParam("id") Long id, Command entity);

    @PermitAll
    @LinkResource(value = Command.class)
    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEntity(@PathParam("id") Long id);    
}