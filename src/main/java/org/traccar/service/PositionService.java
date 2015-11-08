package org.traccar.service;

import arch.repository.Repository;
import arch.service.BaseService;
import arch.service.Service;
import javax.inject.Inject;
import org.traccar.entity.Position;
import org.traccar.repository.PositionRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionService extends BaseService<Position, Long> implements Service<Position, Long> {

    private static final long serialVersionUID = 6724032880321896946L;

    @Inject
    private PositionRepository positionRepository;

    @Override
    public Repository<Position, Long> getRepository() {
        return positionRepository;
    }

    public Position getPositionToImport() {
        return null;
    }
}
