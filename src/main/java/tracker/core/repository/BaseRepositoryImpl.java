package tracker.core.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
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
    public Long countAll() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(entityClass)));
        TypedQuery<Long> typedQuery = getEntityManager().createQuery(criteriaQuery);
        Long count = typedQuery.getSingleResult();
        return count;
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
    public Long countByFilter(BaseFilter filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<EntityType> findAllWithPagination(Integer offset, Integer limit) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<EntityType> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        TypedQuery typedQuery = getEntityManager().createQuery(criteriaQuery);
        List<EntityType> entities = typedQuery
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        return entities;
    }
    
    @Override
    public Long countAllWithPagination(Integer offset, Integer limit) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(entityClass)));
        TypedQuery<Long> typedQuery = getEntityManager().createQuery(criteriaQuery);
        Long count = typedQuery
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getSingleResult();
        return count;
    }

    @Override
    public List<EntityType> findByFilterWithPagination(BaseFilter filter, Integer offset, Integer limit) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<EntityType> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        if (filter != null) {
            CriteriaFilterImpl.applyCriteriaFilterAnnotations(criteriaBuilder, criteriaQuery, root, filter);
        }
        TypedQuery typedQuery = getEntityManager().createQuery(criteriaQuery);
        List<EntityType> entities = typedQuery
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        return entities;
    }    

    @Override
    public Long countByFilterWithPagination(BaseFilter filter, Integer offset, Integer limit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EntityType> findByMapListWithPagination(List<Map<String, String>> mapList, Integer offset, Integer limit) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<EntityType> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        if (mapList != null && !mapList.isEmpty()) {
            for (Map<String, String> filter : mapList) {
                for (Map.Entry<String, String> entry : filter.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    criteriaQuery.where(criteriaBuilder.equal(root.get(key), value));
                }
            }
        }
        TypedQuery typedQuery = getEntityManager().createQuery(criteriaQuery);
        List<EntityType> entities = typedQuery
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
        return entities;
    }    

    @Override
    public Long countByMapListWithPagination(List<Map<String, String>> mapList, Integer offset, Integer limit) {
        throw new UnsupportedOperationException("Not supported yet.");
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