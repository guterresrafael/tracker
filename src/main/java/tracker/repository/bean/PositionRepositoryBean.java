package tracker.repository.bean;

import arch.repository.BaseRepository;
import tracker.entity.Position;
import tracker.repository.PositionRepository;

/**
 *
 * @author Rafael Guterres
 */
public class PositionRepositoryBean extends BaseRepository<Position, Long> implements PositionRepository {

    private static final long serialVersionUID = 9070817428206016173L;
}
