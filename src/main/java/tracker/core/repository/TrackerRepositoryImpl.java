package tracker.core.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tracker.core.entity.BaseEntity;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public class TrackerRepositoryImpl<EntityType extends BaseEntity, IdType extends Serializable> 
     extends BaseRepositoryImpl<EntityType, IdType>
  implements TrackerRepository<EntityType, IdType> {

    @PersistenceContext(unitName = "tracker")
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}