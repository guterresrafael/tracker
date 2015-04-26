package tracker.core.resource;

import com.fasterxml.jackson.core.JsonEncoding;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import tracker.core.entity.BaseEntity;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
public abstract class BaseResourceImpl<EntityType extends BaseEntity, IdType extends Serializable>
        implements BaseResource<EntityType, IdType> {

    private static final String ENCODING_DEFAULT_VALUE = "UTF-8";
    
    private static final String OFFSET_KEY_PARAM = "offset";
    private static final Integer OFFSET_DEFAULT_VALUE = 0;
    
    private static final String LIMIT_KEY_PARAM = "limit";
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
            Integer offset = getOffsetValue(request);
            Integer limit = getLimitValue(request);
            List<EntityType> entities = getService().findByPagination(offset, limit);
            if (entities.isEmpty()) {
                return getResponseBuilder().notFound();
            }
            return getResponseBuilder().ok(entities);
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
    
    private Integer getOffsetValue(HttpServletRequest request) {
        try {
            return Integer.parseInt(request.getParameter(OFFSET_KEY_PARAM));
        } catch (Exception e) {
            return OFFSET_DEFAULT_VALUE;
        }
    }
    
    private Integer getLimitValue(HttpServletRequest request) {
        try {
            return Integer.parseInt(request.getParameter(LIMIT_KEY_PARAM));
        } catch (Exception e) {
            return getLimitDefaultValue();
        }
    }
}
