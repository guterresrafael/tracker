package rs.pelotas.tracker.resource;

import java.io.Serializable;
import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rafael Guterres
 */
@Path("/")
public interface ApplicationResource extends Serializable {
    
    @PermitAll
    @GET
    @Path("/ping")
    public Response getPing();
    
    @PermitAll
    @GET
    @Path("/version")
    public Response getVersion();
}