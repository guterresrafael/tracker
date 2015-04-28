package rs.pelotas.tracker.service;

import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.PositionTraccar;

/**
 *
 * @author Rafael Guterres
 */
public interface PositionTraccarService extends BaseService<PositionTraccar, Long> {

    PositionTraccar getPositionToImport();
}