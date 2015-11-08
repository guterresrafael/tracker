package tracker.resource.bean;

import arch.resource.BaseResource;
import arch.service.Service;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import tracker.entity.Device;
import tracker.entity.User;
import tracker.resource.UserResource;
import tracker.service.DeviceService;
import tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
@RequestScoped
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
