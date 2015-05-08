package rs.pelotas.tracker.repository;

import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.PositionTraccar;

/**
 *
 * @author Rafael Guterres
 */
public class PositionTraccarRepository extends TraccarRepository<PositionTraccar, Long> implements Repository<PositionTraccar, Long> {

    public PositionTraccar getPositionToImport() {
        return null;
    }
}