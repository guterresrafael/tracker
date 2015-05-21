package rs.pelotas.tracker.repository.bean;

import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.Command;
import rs.pelotas.tracker.repository.CommandRepository;

/**
 *
 * @author Rafael Guterres
 */
public class CommandRepositoryBean extends BaseRepository<Command, Long> implements CommandRepository {
    
    private static final long serialVersionUID = 9044928648831619070L;
}
