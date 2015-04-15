package tracker.core.service;

import java.io.Serializable;
import java.util.List;
import tracker.core.entity.BaseEntity;
import tracker.core.filter.BaseFilter;
import tracker.core.repository.BaseRepository;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public interface BaseService<EntityType extends BaseEntity, IdType extends Serializable> {
    
    BaseRepository<EntityType, IdType> getRepository();
    
    EntityType load(IdType id);

    EntityType save(EntityType entity);
    
    void delete(IdType id);
    
    List<EntityType> findAll();
    
    List<EntityType> findByFilter(BaseFilter filter);
}