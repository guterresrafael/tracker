package rs.pelotas.tracker.repository.bean;

import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.repository.PositionRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionRepositoryBean extends BaseRepository<Position, Long> implements PositionRepository {

    private static final long serialVersionUID = 9070817428206016173L;
}
