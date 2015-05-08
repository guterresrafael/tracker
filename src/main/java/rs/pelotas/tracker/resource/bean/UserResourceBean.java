package rs.pelotas.tracker.resource.bean;

import java.util.Collection;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.resource.UserResource;
import rs.pelotas.tracker.service.DeviceService;
import rs.pelotas.tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class UserResourceBean extends BaseResource<User, Long> implements UserResource {
    
    @Inject
    UserService userService;

    @Inject
    DeviceService deviceService;

    @Override
    public Service<User, Long> getService() {
        return userService;
    }
    
    @Override
    public Collection<Device> getDevices(Long userId) {
        return deviceService.findDevicesByUserId(userId);
    }
}