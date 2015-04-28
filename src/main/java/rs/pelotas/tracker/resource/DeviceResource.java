package rs.pelotas.tracker.resource;

import javax.ws.rs.Path;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
@Path("/devices")
public interface DeviceResource extends BaseResource<Device, Long> {
    
}
