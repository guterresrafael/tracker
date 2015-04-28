package rs.pelotas.tracker.resource;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResourceImpl;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.PositionTraccar;
import rs.pelotas.tracker.service.PositionTraccarService;

/**
 *
 * @author Rafael Guterres
 */
public class PositionTraccarResourceImpl extends BaseResourceImpl<PositionTraccar, Long> implements PositionTraccarResource {

    @Inject
    PositionTraccarService positionTraccarService;
    
    @Override
    public BaseService<PositionTraccar, Long> getService() {
        return positionTraccarService;
    }
    
}
