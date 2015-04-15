package tracker.core.repository;

import java.io.Serializable;
import tracker.core.entity.BaseEntity;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public interface TrackerRepository<EntityType extends BaseEntity, IdType extends Serializable> 
         extends BaseRepository<EntityType, IdType> {

}
