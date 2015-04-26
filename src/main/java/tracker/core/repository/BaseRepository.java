package tracker.core.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import tracker.core.entity.BaseEntity;
import tracker.core.filter.BaseFilter;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public interface BaseRepository<EntityType extends BaseEntity, IdType extends Serializable> 
         extends Serializable {

    EntityManager getEntityManager();

    EntityType load(IdType id);

    void persist(EntityType entity);

    EntityType merge(EntityType entity);

    void remove(IdType id);

    List<EntityType> findAll();
    
    Long countAll();
    
    List<EntityType> findByFilter(BaseFilter filter);
    
    Long countByFilter(BaseFilter filter);

    List<EntityType> findAllWithPagination(Integer offset, Integer limit);
    
    Long countAllWithPagination(Integer offset, Integer limit);
    
    List<EntityType> findByFilterWithPagination(BaseFilter filter, Integer offset, Integer limit);
    
    Long countByFilterWithPagination(BaseFilter filter, Integer offset, Integer limit);

    Path getPath(Root root, String strPath);
}