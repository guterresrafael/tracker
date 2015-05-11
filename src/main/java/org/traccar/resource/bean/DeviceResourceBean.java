package org.traccar.resource.bean;

import java.util.Collection;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import org.traccar.entity.Device;
import org.traccar.resource.DeviceResource;
import org.traccar.service.DeviceService;

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