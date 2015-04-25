package tracker.core.web;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Rafael Guterres
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    public static final String ACCESS_CONTROL_ALLOW_ORIGIN_KEY = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN_VALUE = "*";
    
    public static final String ACCESS_CONTROL_ALLOW_HEADERS_KEY = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS_VALUE = "origin, content-type, accept, authorization";
    
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS_KEY = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS_VALUE = "true";
    
    public static final String ACCESS_CONTROL_ALLOW_METHODS_KEY = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_METHODS_VALUE = "GET, POST, PUT, DELETE, OPTIONS, HEAD";
    
    public static final String ACCESS_CONTROL_MAX_AGE_KEY = "Access-Control-Max-Age";
    public static final String ACCESS_CONTROL_MAX_AGE_VALUE = "1209600";
    
    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN_KEY, ACCESS_CONTROL_ALLOW_ORIGIN_VALUE);
        response.getHeaders().add(ACCESS_CONTROL_ALLOW_HEADERS_KEY, ACCESS_CONTROL_ALLOW_HEADERS_VALUE);
        response.getHeaders().add(ACCESS_CONTROL_ALLOW_CREDENTIALS_KEY, ACCESS_CONTROL_ALLOW_CREDENTIALS_VALUE);
        response.getHeaders().add(ACCESS_CONTROL_ALLOW_METHODS_KEY, ACCESS_CONTROL_ALLOW_METHODS_VALUE);
        response.getHeaders().add(ACCESS_CONTROL_MAX_AGE_KEY, ACCESS_CONTROL_MAX_AGE_VALUE);
    }
}