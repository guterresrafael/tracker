package tracker.resource.bean;

import arch.resource.ResponseBuilder;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import tracker.entity.Application;
import tracker.entity.Command;
import tracker.entity.Device;
import tracker.entity.Position;
import tracker.entity.User;
import tracker.resource.ApplicationResource;

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
    public Response getDashboard() {
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
