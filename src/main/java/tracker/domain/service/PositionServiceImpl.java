package tracker.domain.service;

import javax.inject.Inject;
import tracker.core.repository.BaseRepository;
import tracker.core.service.BaseServiceImpl;
import tracker.domain.entity.Position;
import tracker.domain.repository.PositionRepository;

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