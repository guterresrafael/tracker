package rs.pelotas.tracker.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.PositionTraccar;
import rs.pelotas.tracker.repository.PositionTraccarRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionTraccarService extends BaseService<PositionTraccar, Long> implements Service<PositionTraccar, Long> {

    @Inject
    PositionTraccarRepository positionTraccarRepository;
    
    @Override
    public Repository<PositionTraccar, Long> getRepository() {
        return positionTraccarRepository;
    }    

    public PositionTraccar getPositionToImport() {
        return positionTraccarRepository.getPositionToImport();
    }
}
