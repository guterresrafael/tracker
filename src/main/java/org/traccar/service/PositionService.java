package org.traccar.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import org.traccar.entity.Position;
import org.traccar.repository.PositionRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionService extends BaseService<Position, Long> implements Service<Position, Long> {

    private static final long serialVersionUID = 6724032880321896946L;

    @Inject
    PositionRepository positionRepository;

    @Override
    public Repository<Position, Long> getRepository() {
        return positionRepository;
    }
    
    public Position getPositionToImport() {
        return null;
    }
}