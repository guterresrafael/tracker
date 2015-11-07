package rs.pelotas.tracker.resource.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.resource.CommandResource;
import rs.pelotas.tracker.service.CommandService;

/**
 *
 * @author Rafael Guterres
 */
@RequestScoped
public class CommandResourceBean extends BaseResource<Command, Long> implements CommandResource {

    private static final long serialVersionUID = -1527652534931195579L;

    @Inject
    private CommandService commandService;

    @Override
    public Service<Command, Long> getService() {
        return commandService;
    }
}
