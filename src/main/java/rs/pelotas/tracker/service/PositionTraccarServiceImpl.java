package rs.pelotas.tracker.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.service.BaseServiceImpl;
import rs.pelotas.tracker.entity.PositionTraccar;
import rs.pelotas.tracker.repository.PositionTraccarRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionTraccarServiceImpl 
     extends BaseServiceImpl<PositionTraccar, Long> 
  implements PositionTraccarService {

    @Inject
    PositionTraccarRepository positionTraccarRepository;
    
    @Override
    public BaseRepository<PositionTraccar, Long> getRepository() {
        return positionTraccarRepository;
    }    

    @Override
    public PositionTraccar getPositionToImport() {
        return positionTraccarRepository.getPositionToImport();
    }
}
