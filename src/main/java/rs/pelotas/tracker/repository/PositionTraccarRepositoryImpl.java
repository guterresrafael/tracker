package rs.pelotas.tracker.repository;

import rs.pelotas.tracker.entity.PositionTraccar;

/**
 *
 * @author Rafael Guterres
 */
public class PositionTraccarRepositoryImpl 
     extends TraccarRepositoryImpl<PositionTraccar, Long>
  implements PositionTraccarRepository {

    @Override
    public PositionTraccar getPositionToImport() {
        return null;
    }
}