package rs.pelotas.tracker.repository;

import rs.pelotas.tracker.entity.PositionTraccar;

/**
 *
 * @author Rafael Guterres
 */
public interface PositionTraccarRepository extends TraccarRepository<PositionTraccar, Long> {

    PositionTraccar getPositionToImport();
}