package org.traccar.repository;

import arch.repository.Repository;
import org.traccar.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
public class PositionRepository extends BaseTraccarRepository<Position, Long> implements Repository<Position, Long> {

    private static final long serialVersionUID = 9070817428206016173L;
}
