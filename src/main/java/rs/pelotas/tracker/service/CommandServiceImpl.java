package rs.pelotas.tracker.service;

import javax.inject.Inject;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.service.BaseServiceImpl;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.repository.CommandRepository;

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
