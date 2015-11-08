package tracker.resource.bean;

import arch.resource.BaseResource;
import arch.service.Service;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import tracker.entity.Device;
import tracker.entity.User;
import tracker.resource.DeviceResource;
import tracker.service.DeviceService;
import tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
@RequestScoped
public class DeviceResourceBean extends BaseResource<Device, Long> implements DeviceResource {

    private static final long serialVersionUID = 9145212157187874341L;

    @Inject
    private DeviceService deviceService;

    @Inject
    private UserService userService;

    @Override
    public Service<Device, Long> getService() {
        return deviceService;
    }

    @Override
    public List<User> getUsers(Long deviceId) {
        return userService.findUsersByDevicesId(deviceId);
    }
}
