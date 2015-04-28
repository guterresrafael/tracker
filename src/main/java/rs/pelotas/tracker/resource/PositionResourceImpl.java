package rs.pelotas.tracker.resource;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResourceImpl;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
public class PositionResourceImpl extends BaseResourceImpl<Position, Long> implements PositionResource {

    @Inject
    PositionService positionService;
    
    @Override
    public BaseService<Position, Long> getService() {
        return positionService;
    }
    
}
