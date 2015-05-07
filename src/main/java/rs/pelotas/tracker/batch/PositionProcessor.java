package rs.pelotas.tracker.batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import rs.pelotas.arch.helper.Assembler;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.entity.PositionTraccar;

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
            PositionTraccar positionTraccar = (PositionTraccar) object;
            Position positionTracker = new Position();
            Assembler.assembler(positionTraccar, positionTracker);
            return positionTracker;
        }
        return null;
    }   
}