package rs.pelotas.tracker.resource;

import javax.ws.rs.Path;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.tracker.entity.Command;

/**
 *
 * @author Rafael Guterres
 */
@Path("/commands")
public interface CommandResource extends BaseResource<Command, Long> {

}
