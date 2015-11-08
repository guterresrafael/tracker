package org.traccar.resource.bean;

import arch.resource.BaseResource;
import arch.service.Service;
import java.util.List;
import javax.inject.Inject;
import org.traccar.entity.Device;
import org.traccar.entity.User;
import org.traccar.resource.UserResource;
import org.traccar.service.DeviceService;
import org.traccar.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class UserResourceBean extends BaseResource<User, Long> implements UserResource {

    private static final long serialVersionUID = -6835862323296783770L;

    @Inject
    private UserService userService;

    @Inject
    private DeviceService deviceService;

    @Override
    public Service<User, Long> getService() {
        return userService;
    }

    @Override
    public List<Device> getDevices(Long userId) {
        return deviceService.findDevicesByUserId(userId);
    }
}
