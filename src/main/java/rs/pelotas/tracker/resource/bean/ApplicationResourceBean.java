package rs.pelotas.tracker.resource.bean;

import javax.ws.rs.core.Response;
import rs.pelotas.arch.resource.ResponseBuilder;
import rs.pelotas.tracker.resource.ApplicationResource;

/**
 * 
 * @author Rafael Guterres
 */
public class ApplicationResourceBean implements ApplicationResource {

    private static final long serialVersionUID = 1429964490392452041L;

    @Override
    public Response getPing() {
        return ResponseBuilder.ok();
    }

    @Override
    public Response getVersion() {
        return ResponseBuilder.ok("1.0.0-SNAPSHOT");
    }

    @Override
    public Response getLogin() {
        return ResponseBuilder.ok();
    }
}