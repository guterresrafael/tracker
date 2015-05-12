package org.traccar.resource.bean;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import rs.pelotas.arch.resource.BaseResource;
import rs.pelotas.arch.service.Service;
import org.traccar.entity.Device;
import org.traccar.entity.User;
import org.traccar.resource.UserResource;
import org.traccar.service.DeviceService;
import org.traccar.service.UserService;
import rs.pelotas.arch.resource.ResponseBuilder;

/**
 *
 * @author Rafael Guterres
 */
public class UserResourceBean extends BaseResource<User, Long> implements UserResource {
    
    private static final long serialVersionUID = -6835862323296783770L;
    
    @Inject
    UserService userService;

    @Inject
    DeviceService deviceService;

    @Override
    public Service<User, Long> getService() {
        return userService;
    }
    
    @Override
    public List<Device> getDevices(Long userId) {
        return deviceService.findDevicesByUserId(userId);
    }
}