package rs.pelotas.tracker.repository;

import java.io.Serializable;
import rs.pelotas.arch.entity.BaseEntity;
import rs.pelotas.arch.repository.BaseRepository;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public interface TrackerRepository<EntityType extends BaseEntity, IdType extends Serializable> 
         extends BaseRepository<EntityType, IdType> {

}
