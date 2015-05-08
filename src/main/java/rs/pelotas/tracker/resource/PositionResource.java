package rs.pelotas.tracker.resource;

import javax.ws.rs.Path;
import rs.pelotas.arch.resource.Resource;
import rs.pelotas.tracker.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
@Path("/positions")
public interface PositionResource extends Resource<Position, Long> {
    
}
