package rs.pelotas.tracker.resource;

import javax.ws.rs.Path;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.tracker.entity.PositionTraccar;

/**
 *
 * @author Rafael Guterres
 */
@Path("/positionsTraccar")
public interface PositionTraccarResource extends BaseResource<PositionTraccar, Long>{
    
}
