package tracker.core.service;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
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

    @Inject
    Validator validator;
    
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
    public Long countAll() {
        return getRepository().countAll();
    }

    @Override
    public List<EntityType> findByFilter(BaseFilter filter) {
        return getRepository().findByFilter(filter);
    }

    @Override
    public Long countByFilter(BaseFilter filter) {
        return getRepository().countByFilter(filter);
    }

    
    @Override
    public List<EntityType> findAllWithPagination(Integer offset, Integer limit) {
        return getRepository().findAllWithPagination(offset, limit);
    }

    @Override
    public Long countAllWithPagination(Integer offset, Integer limit) {
        return getRepository().countAllWithPagination(offset, limit);
    }

    @Override
    public List<EntityType> findByFilterWithPagination(BaseFilter filter, Integer offset, Integer limit) {
        return getRepository().findByFilterWithPagination(filter, offset, limit);
    }
    
    @Override
    public Long countByFilterWithPagination(BaseFilter filter, Integer offset, Integer limit) {
        return getRepository().countByFilterWithPagination(filter, offset, limit);
    }
    
    @Override
    public void validate(EntityType entity) throws ConstraintViolationException {
        Set<ConstraintViolation<EntityType>> violations = validator.validate(entity);
        
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }
}