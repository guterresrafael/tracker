package rs.pelotas.tracker.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.repository.PositionRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionService extends BaseService<Position, Long> implements Service<Position, Long> {
    
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