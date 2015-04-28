package rs.pelotas.tracker.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.service.BaseServiceImpl;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.repository.PositionRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionServiceImpl
     extends BaseServiceImpl<Position, Long>
  implements PositionService {
    
    @Inject
    PositionRepository positionRepository;

    @Override
    public BaseRepository<Position, Long> getRepository() {
        return positionRepository;
    }
}