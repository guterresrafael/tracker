package tracker.resource;

import arch.resource.ApplicationPath;
import arch.security.role.ApplicationRole;
import java.io.Serializable;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;
import tracker.entity.Application;
import tracker.entity.Command;
import tracker.entity.Device;
import tracker.entity.Position;
import tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Path(ApplicationPath.APPLICATION)
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public interface ApplicationResource extends Serializable {

    @PermitAll
    @AddLinks
    @GET
    @Path("/")
    Response getApplication();

    @RolesAllowed({ApplicationRole.DASHBOARD})
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(ApplicationPath.DASHBOARD)
    Response getDashboard();

    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.USERS)
    Response getResource(User user);

    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.DEVICES)
    Response getResource(Device device);

    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.POSITIONS)
    Response getResource(Position position);

    @PermitAll
    @AddLinks
    @LinkResource(rel = "list", value = Application.class)
    @GET
    @Path(AppResourcePath.COMMANDS)
    Response getResource(Command command);
}
