package tracker.legacy.batch;

import java.io.Serializable;
import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import tracker.legacy.entity.Position;
import tracker.legacy.service.PositionService;

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