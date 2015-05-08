package rs.pelotas.tracker.resource.bean;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.resource.PositionResource;
import rs.pelotas.tracker.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
public class PositionResourceBean extends BaseResource<Position, Long> implements PositionResource {

    @Inject
    PositionService positionService;
    
    @Override
    public Service<Position, Long> getService() {
        return positionService;
    }
    
}
