package tracker.service.bean;

import arch.repository.Repository;
import arch.service.BaseService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tracker.entity.Position;
import tracker.repository.PositionRepository;
import tracker.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public class PositionServiceBean extends BaseService<Position, Long> implements PositionService {

    private static final long serialVersionUID = -2496030139227407311L;

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
