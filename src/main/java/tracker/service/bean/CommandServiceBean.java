package tracker.service.bean;

import arch.repository.Repository;
import arch.service.BaseService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tracker.entity.Command;
import tracker.repository.CommandRepository;
import tracker.service.CommandService;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public class CommandServiceBean extends BaseService<Command, Long> implements CommandService {

    private static final long serialVersionUID = 4052449166823238992L;

    @Inject
    private CommandRepository commandRepository;

    @Override
    public Repository<Command, Long> getRepository() {
        return commandRepository;
    }
}
