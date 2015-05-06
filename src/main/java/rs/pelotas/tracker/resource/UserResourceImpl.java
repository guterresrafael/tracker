package rs.pelotas.tracker.resource;

import java.util.Collection;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResourceImpl;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.service.DeviceService;
import rs.pelotas.tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class UserResourceImpl extends BaseResourceImpl<User, Long> implements UserResource {
    
    @Inject
    UserService userService;
    
    @Inject
    DeviceService deviceService;

    @Override
    public BaseService<User, Long> getService() {
        return userService;
    }

    @Override
    public Collection<Device> getDevices(Long userId) {
        return deviceService.findDevicesByUserId(userId);
    }
}