package tracker.batch;

import arch.helper.Assembler;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.traccar.entity.Position;

/**
 *
 * @author Rafael Guterres
 */
@Dependent
@Named(value = "PositionProcessor")
public class PositionProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object object) throws Exception {
        if (object != null) {
            Position positionTraccar = (Position) object;
            Position positionTracker = new Position();
            Assembler.assembler(positionTraccar, positionTracker);
            return positionTracker;
        }
        return null;
    }
}
