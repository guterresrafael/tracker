package rs.pelotas.tracker.resource.bean;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import rs.pelotas.arch.resource.ResponseBuilder;
import rs.pelotas.tracker.entity.Application;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.resource.ApplicationResource;

/**
 * 
 * @author Rafael Guterres
 */
@RequestScoped
public class ApplicationResourceBean implements ApplicationResource {

    private static final long serialVersionUID = 1429964490392452041L;

    @Override
    public Response getApplication() {
        return ResponseBuilder.ok(new Application());
    }

    @Override
    public Response getLogin() {
        return ResponseBuilder.ok();
    }

    @Override
    public Response getResource(Command command) {
        return ResponseBuilder.ok();
    }

    @Override
    public Response getResource(User user) {
        return ResponseBuilder.ok();
    }

    @Override
    public Response getResource(Device device) {
        return ResponseBuilder.ok();
    }

    @Override
    public Response getResource(Position position) {
        return ResponseBuilder.ok();
    }
}