package org.traccar.service;

import arch.repository.Repository;
import arch.service.BaseService;
import arch.service.Service;
import javax.inject.Inject;
import org.traccar.entity.Command;
import org.traccar.repository.CommandRepository;

/**
 *
 * @author Rafael Guterres
 */
public class CommandService extends BaseService<Command, Long> implements Service<Command, Long> {

    private static final long serialVersionUID = -5844347019434782533L;

    @Inject
    private CommandRepository commandRepository;

    @Override
    public Repository<Command, Long> getRepository() {
        return commandRepository;
    }
}
