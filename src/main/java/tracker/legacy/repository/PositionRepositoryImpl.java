package tracker.legacy.repository;

import tracker.core.repository.TraccarRepositoryImpl;
import tracker.legacy.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
public class PositionRepositoryImpl 
     extends TraccarRepositoryImpl<Position, Long>
  implements PositionRepository {

    @Override
    public Position getPositionToImport() {
        return null;
    }
}