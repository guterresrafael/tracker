package rs.pelotas.tracker.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.pelotas.arch.entity.BaseEntity;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.repository.Repository;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public class TrackerRepository<EntityType extends BaseEntity, IdType extends Serializable> 
     extends BaseRepository<EntityType, IdType>
  implements Repository<EntityType, IdType> {

    @PersistenceContext(unitName = "tracker")
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}