package tracker.core.resource;

import java.io.Serializable;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tracker.core.entity.BaseEntity;
import tracker.core.service.BaseService;

/**
 *
 * @author Rafael Guterres
 * @param <EntityType>
 * @param <IdType>
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BaseResource<EntityType extends BaseEntity, IdType extends Serializable> extends Serializable {
    
    BaseService<EntityType, IdType> getService();
    
    ResponseBuilder getResponseBuilder();

    Integer getLimitDefaultValue();
    
    @PermitAll
    @GET
    @Path("/{id}")
    Response getEntityById(@PathParam("id") IdType id);
    
    @PermitAll
    @GET
    @Path("/")
    Response getEntities(@Context HttpServletRequest request);    
    
    @PermitAll
    @POST
    @Path("/")
    Response postEntity(EntityType entity);

    @PermitAll
    @PUT
    @Path("/")
    Response putEntity(EntityType entity);
    
    @PermitAll
    @DELETE
    @Path("/{id}")
    Response deleteEntity(@PathParam("id") IdType id);
}