package tracker.domain.resource;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import tracker.domain.entity.Command;
import tracker.domain.filter.CommandFilter;
import tracker.domain.service.CommandService;

/**
 *
 * @author Rafael Guterres
 */
@Path("/commands")
public class CommandResource {
    
    @Inject
    CommandService commandService;
    
    @PermitAll
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Command> getCommands() {
        List<Command> commands = commandService.findAll();
        if (commands.isEmpty()) {
            //TODO: Implementar NotFound
        }
        return commands;
    }
    
    @PermitAll
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Command getCommand(@PathParam("id") Long id) {
        Command command = commandService.load(id);
        if (command == null) {
            //TODO: Implementar NotFound
        }
        return command;
    }
    
    @PermitAll
    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Command> getCommandsByFilter(@QueryParam("deviceId") Long deviceId) {
        CommandFilter commandFilter = new CommandFilter();
        commandFilter.setDeviceId(deviceId);
        List<Command> commands = commandService.findByFilter(commandFilter);
        if (commands.isEmpty()) {
            //TODO: Implementar NotFound
        }
        return commands;
    }
}
