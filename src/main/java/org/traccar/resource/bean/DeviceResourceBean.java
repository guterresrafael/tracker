package org.traccar.resource.bean;

import arch.resource.BaseResource;
import arch.service.Service;
import java.util.List;
import javax.inject.Inject;
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
    private DeviceService deviceService;

    @Override
    public Service<Device, Long> getService() {
        return deviceService;
    }

    @Override
    public List<Device> getUsers(Long deviceId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
