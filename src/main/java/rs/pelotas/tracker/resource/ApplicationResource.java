package rs.pelotas.tracker.resource;

import java.io.Serializable;
import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Rafael Guterres
 */
@Path("app")
public interface ApplicationResource extends Serializable {
    
    @PermitAll
    @GET
    @Path("/version")
    public String getVersion();
}