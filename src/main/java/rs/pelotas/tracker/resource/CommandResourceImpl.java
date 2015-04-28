package rs.pelotas.tracker.resource;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResourceImpl;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.service.CommandService;

/**
 *
 * @author Rafael Guterres
 */
public class CommandResourceImpl extends BaseResourceImpl<Command, Long> implements CommandResource {

    @Inject
    CommandService commandService;
    
    @Override
    public BaseService<Command, Long> getService() {
        return commandService;
    }
}
