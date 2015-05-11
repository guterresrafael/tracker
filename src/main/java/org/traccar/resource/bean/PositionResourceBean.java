package org.traccar.resource.bean;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import org.traccar.entity.Position;
import org.traccar.resource.PositionResource;
import org.traccar.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
public class PositionResourceBean extends BaseResource<Position, Long> implements PositionResource {
    
    private static final long serialVersionUID = 3630413584076355265L;

    @Inject
    PositionService positionService;
    
    @Override
    public Service<Position, Long> getService() {
        return positionService;
    }  
}
