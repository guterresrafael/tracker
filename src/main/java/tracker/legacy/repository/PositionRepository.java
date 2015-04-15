package tracker.legacy.repository;

import tracker.core.repository.TraccarRepository;
import tracker.legacy.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
public interface PositionRepository extends TraccarRepository<Position, Long> {

    Position getPositionToImport();
}