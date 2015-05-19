package rs.pelotas.tracker.repository;

import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.Command;

/**
 *
 * @author Rafael Guterres
 */
public class CommandRepository extends BaseRepository<Command, Long> implements Repository<Command, Long> {
    
    private static final long serialVersionUID = 9044928648831619070L;
}
