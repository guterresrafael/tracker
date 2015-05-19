package rs.pelotas.tracker.repository;

import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
public class PositionRepository extends BaseRepository<Position, Long> implements Repository<Position, Long> {

    private static final long serialVersionUID = 9070817428206016173L;
}