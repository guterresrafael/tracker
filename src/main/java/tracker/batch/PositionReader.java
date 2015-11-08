package tracker.batch;

import java.io.Serializable;
import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import org.traccar.entity.Position;
import org.traccar.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
@Dependent
@Named(value = "PositionReader")
public class PositionReader implements ItemReader {

    @Inject
    private PositionService positionService;

    private Position position;

    @Override
    public void open(Serializable srlzbl) throws Exception {
        position = positionService.getPositionToImport();
    }

    @Override
    public void close() throws Exception {
        //Do nothing.
    }

    @Override
    public Object readItem() throws Exception {
        return position;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return position;
    }
}
