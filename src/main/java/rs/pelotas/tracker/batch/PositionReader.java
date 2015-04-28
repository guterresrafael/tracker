package rs.pelotas.tracker.batch;

import java.io.Serializable;
import javax.batch.api.chunk.ItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import rs.pelotas.tracker.entity.PositionTraccar;
import rs.pelotas.tracker.service.PositionTraccarService;

/**
 *
 * @author Rafael Guterres
 */
@Dependent
@Named(value = "PositionReader")
public class PositionReader implements ItemReader {

    @Inject
    private PositionTraccarService positionService;
    
    private PositionTraccar position;
    
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