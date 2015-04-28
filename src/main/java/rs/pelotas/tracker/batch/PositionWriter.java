package rs.pelotas.tracker.batch;

import java.io.Serializable;
import java.util.List;
import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import rs.pelotas.tracker.entity.Position;
import rs.pelotas.tracker.service.PositionService;

/**
 *
 * @author Rafael Guterres
 */
@Dependent
@Named(value = "PositionWriter")
public class PositionWriter implements ItemWriter {

    @Inject
    private PositionService positionService;
    
    @Override
    public void open(Serializable srlzbl) throws Exception {
    }

    @Override
    public void close() throws Exception {
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        for (Object object : items) {
            if (object != null) {
                Position position = (Position) object;
                positionService.save(position);
            }
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}