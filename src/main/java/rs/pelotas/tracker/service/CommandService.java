package rs.pelotas.tracker.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.repository.CommandRepository;

/**
 *
 * @author Rafael Guterres
 */
public class CommandService extends BaseService<Command, Long> implements Service<Command, Long> {
    
    @Inject
    CommandRepository commandRepository;

    @Override
    public Repository<Command, Long> getRepository() {
        return commandRepository;
    }
}
