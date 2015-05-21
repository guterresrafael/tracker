package org.traccar.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import org.traccar.entity.Command;
import org.traccar.repository.CommandRepository;

/**
 *
 * @author Rafael Guterres
 */
public class CommandService extends BaseService<Command, Long> implements Service<Command, Long> {

    private static final long serialVersionUID = -5844347019434782533L;

    @Inject
    CommandRepository commandRepository;

    @Override
    public Repository<Command, Long> getRepository() {
        return commandRepository;
    }
}
