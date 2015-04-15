package tracker.legacy.batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import tracker.core.annotation.AssemblerImpl;
import tracker.legacy.entity.Position;

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
            Position position = (Position) object;
            tracker.domain.entity.Position trackerPosition = new tracker.domain.entity.Position();
            AssemblerImpl.assembler(position, trackerPosition);
            return trackerPosition;
        }
        return null;
    }   
}