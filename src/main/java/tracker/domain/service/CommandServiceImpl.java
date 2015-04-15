package tracker.domain.service;

import javax.inject.Inject;
import tracker.core.repository.BaseRepository;
import tracker.core.service.BaseServiceImpl;
import tracker.domain.entity.Command;
import tracker.domain.repository.CommandRepository;

/**
 *
 * @author Rafael Guterres
 */
public class CommandServiceImpl 
     extends BaseServiceImpl<Command, Long> 
  implements CommandService {
    
    @Inject
    CommandRepository commandRepository;

    @Override
    public BaseRepository<Command, Long> getRepository() {
        return commandRepository;
    }
}
