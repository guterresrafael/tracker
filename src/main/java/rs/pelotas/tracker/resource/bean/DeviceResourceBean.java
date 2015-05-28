package rs.pelotas.tracker.resource.bean;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.resource.DeviceResource;
import rs.pelotas.tracker.service.DeviceService;
import rs.pelotas.tracker.service.UserService;

/**
 * 
 * @author Rafael Guterres
 */
@RequestScoped
public class DeviceResourceBean extends BaseResource<Device, Long> implements DeviceResource {
    
    private static final long serialVersionUID = 9145212157187874341L;

    @Inject
    DeviceService deviceService;
    
    @Inject
    UserService userService;
    
    @Override
    public Service<Device, Long> getService() {
        return deviceService;
    }
    
    @Override
    public List<User> getUsers(Long deviceId) {
        return userService.findUsersByDevicesId(deviceId);
    }
}