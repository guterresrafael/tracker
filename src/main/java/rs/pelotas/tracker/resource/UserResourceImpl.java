package rs.pelotas.tracker.resource;

import javax.inject.Inject;
import rs.pelotas.arch.resource.BaseResourceImpl;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class UserResourceImpl extends BaseResourceImpl<User, Long> implements UserResource {
    
    @Inject
    UserService userService;

    @Override
    public BaseService<User, Long> getService() {
        return userService;
    }
}