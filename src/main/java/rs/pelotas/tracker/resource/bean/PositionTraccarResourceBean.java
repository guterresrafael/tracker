package rs.pelotas.tracker.resource.bean;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.PositionTraccar;
import rs.pelotas.tracker.resource.PositionTraccarResource;
import rs.pelotas.tracker.service.PositionTraccarService;

/**
 *
 * @author Rafael Guterres
 */
public class PositionTraccarResourceBean extends BaseResource<PositionTraccar, Long> implements PositionTraccarResource {
    
    private static final long serialVersionUID = -8917174923477988L;

    @Inject
    PositionTraccarService positionTraccarService;
    
    @Override
    public Service<PositionTraccar, Long> getService() {
        return positionTraccarService;
    }
    
}
