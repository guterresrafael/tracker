package org.traccar.resource.bean;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import org.traccar.entity.Command;
import org.traccar.resource.CommandResource;
import org.traccar.service.CommandService;

/**
 *
 * @author Rafael Guterres
 */
public class CommandResourceBean extends BaseResource<Command, Long> implements CommandResource {

    private static final long serialVersionUID = -1527652534931195579L;

    @Inject
    private CommandService commandService;

    @Override
    public Service<Command, Long> getService() {
        return commandService;
    }
}
