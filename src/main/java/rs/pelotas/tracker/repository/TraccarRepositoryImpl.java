package rs.pelotas.tracker.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.pelotas.arch.entity.BaseEntity;
import rs.pelotas.arch.repository.BaseRepositoryImpl;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public class TraccarRepositoryImpl<EntityType extends BaseEntity, IdType extends Serializable> 
     extends BaseRepositoryImpl<EntityType, IdType> 
  implements TraccarRepository<EntityType, IdType> {

    @PersistenceContext(unitName = "traccar")
    EntityManager entityManager;
    
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }   
}