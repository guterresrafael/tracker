package rs.pelotas.tracker.service.bean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.repository.PositionRepository;
import rs.pelotas.tracker.service.PositionService;

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
