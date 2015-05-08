package rs.pelotas.tracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.PositionTraccar;

/**
 *
 * @author Rafael Guterres
 */
public class PositionTraccarRepository extends BaseRepository<PositionTraccar, Long> implements Repository<PositionTraccar, Long> {

    @PersistenceContext(unitName = "traccar")
    EntityManager entityManager;
    
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public PositionTraccar getPositionToImport() {
        return null;
    }
}