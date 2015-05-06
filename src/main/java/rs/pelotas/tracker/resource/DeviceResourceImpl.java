package rs.pelotas.tracker.resource;

import java.util.Collection;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResourceImpl;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.service.DeviceService;

/**
 * 
 * @author Rafael Guterres
 */
public class DeviceResourceImpl extends BaseResourceImpl<Device, Long> implements DeviceResource {

    @Inject
    DeviceService deviceService;
    
    @Override
    public BaseService<Device, Long> getService() {
        return deviceService;
    }

    @Override
    public Collection<Device> getUsers(Long deviceId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}