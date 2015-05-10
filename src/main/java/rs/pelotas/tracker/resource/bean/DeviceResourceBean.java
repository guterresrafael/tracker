package rs.pelotas.tracker.resource.bean;

import java.util.Collection;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.resource.DeviceResource;
import rs.pelotas.tracker.service.DeviceService;

/**
 * 
 * @author Rafael Guterres
 */
public class DeviceResourceBean extends BaseResource<Device, Long> implements DeviceResource {
    
    private static final long serialVersionUID = 9145212157187874341L;

    @Inject
    DeviceService deviceService;
    
    @Override
    public Service<Device, Long> getService() {
        return deviceService;
    }
    
    @Override
    public Collection<Device> getUsers(Long deviceId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}