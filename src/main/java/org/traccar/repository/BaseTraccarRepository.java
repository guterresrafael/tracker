package org.traccar.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rs.pelotas.arch.entity.BaseEntity;
import rs.pelotas.arch.repository.BaseRepository;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public abstract class BaseTraccarRepository<EntityType extends BaseEntity, IdType extends Serializable> 
              extends BaseRepository<EntityType, IdType> {
    
    private static final long serialVersionUID = -6526885283678133001L;

    @PersistenceContext(unitName = "traccar")
    EntityManager entityManager;
    
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
