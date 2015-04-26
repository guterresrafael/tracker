package tracker.core.resource;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import tracker.core.entity.BaseEntity;
import tracker.core.utils.Reflection;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public abstract class BaseResourceImpl<EntityType extends BaseEntity, IdType extends Serializable>
           implements BaseResource<EntityType, IdType> {

    private static final Integer LIMIT_DEFAULT_VALUE = 20;
    
    @Inject
    ResponseBuilder responseBuilder;

    @Override
    public ResponseBuilder getResponseBuilder() {
        return responseBuilder;
    }

    @Override
    public Integer getLimitDefaultValue() {
        return LIMIT_DEFAULT_VALUE;
    }

    @Override
    public Response getEntityById(IdType id) {
        EntityType entity = getService().load(id);
        if (entity == null) {
            return getResponseBuilder().notFound();
        }
        return getResponseBuilder().ok(entity);
    }

    @Override
    public Response getEntities(HttpServletRequest request) {
        try {
            QueryParams queryParams = new QueryParams(request);
            Integer offset = queryParams.getOffset();
            Integer limit = (queryParams.getLimit() != null) ? queryParams.getLimit() : getLimitDefaultValue();
            List<EntityType> entities = getService().findAllWithPagination(offset, limit);
            if (entities.isEmpty()) {
                return getResponseBuilder().notFound();
            }
            if (!queryParams.getFields().isEmpty()) {
                List<Map<String, Object>> entitiesMap = createEntitiesMapListByQueryParams(entities, queryParams);
                return getResponseBuilder().ok(entitiesMap);
            } else {
                return getResponseBuilder().ok(entities);
            }
        } catch (Exception e) {
            return getResponseBuilder().badRequest(e);
        }
    }

    @Override
    public Response postEntity(EntityType entity) {
        try {
            getService().validate(entity);
            entity = getService().save(entity);
            return getResponseBuilder().ok(entity);
        } catch (ConstraintViolationException cve) {
            return getResponseBuilder().badRequest(cve);
        } catch (Exception e) {
            return getResponseBuilder().badRequest(e);
        }
    }

    @Override
    public Response putEntity(EntityType entity) {
        try {
            getService().validate(entity);
            entity = getService().save(entity);
            return getResponseBuilder().ok(entity);
        } catch (ConstraintViolationException cve) {
            return getResponseBuilder().badRequest(cve);
        } catch (Exception e) {
            return getResponseBuilder().conflict(e);
        }
    }

    @Override
    public Response deleteEntity(IdType id) {
        try {
            getService().delete(id);
        } catch (Exception e) {
            return getResponseBuilder().conflict(e);
        }
        return getResponseBuilder().deleted();
    }
    
    private List<Map<String, Object>> createEntitiesMapListByQueryParams(List<EntityType> entities, QueryParams queryParams) throws IllegalArgumentException, IllegalAccessException {
        List<Map<String, Object>> entitiesMap = new ArrayList<>();
        for (EntityType entity : entities) {
            Map<String, Object> entityMap = new HashMap<>();
            List<Field> entityFields = new ArrayList<>();
            Reflection.getAllFields(entityFields, entity.getClass());
            for (String fieldParam : queryParams.getFields()) {
                for (Field entityField : entityFields) {
                    entityField.setAccessible(true);
                    if (entityField.getName().equals(fieldParam)) {
                        entityMap.put(fieldParam, entityField.get(entity));
                        break;
                    }
                }
            }
            entitiesMap.add(entityMap);
        }
        return entitiesMap;
    }
}