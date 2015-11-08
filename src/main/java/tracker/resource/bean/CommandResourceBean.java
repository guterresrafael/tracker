package tracker.resource.bean;

import arch.resource.BaseResource;
import arch.service.Service;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import tracker.entity.Command;
import tracker.resource.CommandResource;
import tracker.service.CommandService;

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
