package tracker.domain.resource;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import tracker.domain.entity.Position;
import tracker.domain.filter.PositionFilter;
import tracker.domain.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
@Path("/positions")
public class PositionResource {
    
    @Inject
    PositionService positionService;
    
    @PermitAll
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Position> getPositions() {
        List<Position> positions = positionService.findAll();
        if (positions.isEmpty()) {
            //TODO: Implementar NotFound
        }
        return positions;
    }
    
    @PermitAll
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Position getPositionById(@PathParam("id") Long id) {
        Position position = positionService.load(id);
        if (position == null) {
            //TODO: Implementar NotFound
        }
        return position;
    }

    @PermitAll
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Position> getLastPositionsByDeviceId(@QueryParam("deviceId") Long deviceId,
                                                     @DefaultValue("10") @QueryParam("maxResults") Integer maxResults) {
        PositionFilter positionFilter = new PositionFilter();
        positionFilter.setDeviceId(deviceId);
        positionFilter.setMaxResults(maxResults);
        return positionService.findByFilter(positionFilter);
    }
    
    
}
