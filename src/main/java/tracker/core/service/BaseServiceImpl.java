package tracker.core.service;

import java.io.Serializable;
import java.util.List;
import tracker.core.entity.BaseEntity;
import tracker.core.filter.BaseFilter;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public abstract class BaseServiceImpl<EntityType extends BaseEntity, IdType extends Serializable>
           implements BaseService<EntityType, IdType> {

    @Override
    public EntityType load(IdType id) {
        return getRepository().load(id);
    }

    @Override
    public EntityType save(EntityType entity) {
        if (entity != null && ((BaseEntity) entity).getId() != null) {
            getRepository().persist(entity);
        } else {
            entity = getRepository().merge(entity);
        }
        return entity;
    }

    @Override
    public void delete(IdType id) {
        getRepository().remove(id);
    }

    @Override
    public List<EntityType> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<EntityType> findByFilter(BaseFilter filter) {
        return getRepository().findByFilter(filter);
    }
}