package tracker.core.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Rafael Guterres
 */
public class ResponseBuilder {
    
    public Response ok() {
        return Response.status(Response.Status.OK).build();
    }
    
    public Response ok(Object entity) {
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    public Response ok(List<Object> entities) {
        return Response.status(Response.Status.OK).entity(entities).build();
    }
    
    public Response created() {
        return Response.status(Response.Status.CREATED).build();
    }
    
    public Response created(Object entity) {
        return Response.status(Response.Status.CREATED).entity(entity).build();
    }

    public Response accepted() {
        return Response.status(Response.Status.ACCEPTED).build();
    }

    public Response accepted(Object entity) {
        return Response.status(Response.Status.ACCEPTED).entity(entity).build();
    }
    
    public Response deleted() {
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    public Response notModified() {
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }
    
    public Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    public Response badRequest(Exception exception) {
        String message = exception.getMessage();
        Map<String, String> responseObj = new HashMap<>();
        responseObj.put("error", message);
        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj).build();
    }

    public Response badRequest(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        Map<String, String> responseObj = new HashMap<>();
        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj).build();
    }
    
    public Response unauthorized() {
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
    
    public Response forbidden() {
        return Response.status(Response.Status.FORBIDDEN).build();
    }
    
    public Response notFound() {
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response timeout() {
        return Response.status(Response.Status.REQUEST_TIMEOUT).build();
    }
    
    public Response conflict() {
        return Response.status(Response.Status.CONFLICT).build();
    }
    
    public Response conflict(Exception exception) {
        String message = exception.getMessage();
        Map<String, String> responseObj = new HashMap<>();
        responseObj.put("error", message);
        return Response.status(Response.Status.CONFLICT).entity(responseObj).build();
    }
    
    public Response notImplemented() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}