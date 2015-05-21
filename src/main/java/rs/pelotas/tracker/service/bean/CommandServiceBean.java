package rs.pelotas.tracker.service.bean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.repository.CommandRepository;
import rs.pelotas.tracker.service.CommandService;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public class CommandServiceBean extends BaseService<Command, Long> implements CommandService {

    private static final long serialVersionUID = 4052449166823238992L;
    
    @Inject
    CommandRepository commandRepository;

    @Override
    public Repository<Command, Long> getRepository() {
        return commandRepository;
    }
}
