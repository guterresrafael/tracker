package tracker.repository.bean;

import arch.repository.BaseRepository;
import tracker.entity.Command;
import tracker.repository.CommandRepository;

/**
 *
 * @author Rafael Guterres
 */
public class CommandRepositoryBean extends BaseRepository<Command, Long> implements CommandRepository {

    private static final long serialVersionUID = 9044928648831619070L;
}
