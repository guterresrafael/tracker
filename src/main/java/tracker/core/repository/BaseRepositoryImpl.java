package tracker.core.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import tracker.core.annotation.CriteriaFilterImpl;
import tracker.core.entity.BaseEntity;
import tracker.core.filter.BaseFilter;
import tracker.core.utils.Reflection;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public abstract class BaseRepositoryImpl<EntityType extends BaseEntity, IdType extends Serializable> 
           implements BaseRepository<EntityType, IdType> {
    
    private final Class<EntityType> entityClass = Reflection.getGenericArgumentType(getClass());

    @Override
    public EntityType load(IdType id) {
        EntityType entity = getEntityManager().find(entityClass, id);
        return entity;
    }

    @Override
    public void persist(EntityType entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public EntityType merge(EntityType entity) {
        return (EntityType) getEntityManager().merge(entity);
    }

    @Override
    public void remove(IdType entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public List<EntityType> findAll() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<EntityType> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        TypedQuery typedQuery = getEntityManager().createQuery(criteriaQuery);
        List<EntityType> entities = typedQuery.getResultList();
        return entities;
    }

    @Override
    public List<EntityType> findByFilter(BaseFilter filter) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<EntityType> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        if (filter != null) {
            CriteriaFilterImpl.applyCriteriaFilterAnnotations(criteriaBuilder, criteriaQuery, root, filter);
        }
        TypedQuery<EntityType> typedQuery = getEntityManager().createQuery(criteriaQuery);
        List<EntityType> entities = typedQuery.getResultList();
        return entities;
    }

    @Override
    public Path getPath(Root root, String strPath) {
        Path path = root;
        String[] fields = strPath.split("\\.");
        for (String field : fields) {
            path = path.get(field);
        }
        return path;
    }
}