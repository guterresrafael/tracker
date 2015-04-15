package tracker.legacy.service;

import tracker.core.service.BaseService;
import tracker.legacy.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
public interface PositionService extends BaseService<Position, Long> {

    Position getPositionToImport();
}