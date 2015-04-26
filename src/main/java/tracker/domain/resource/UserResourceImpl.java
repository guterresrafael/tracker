package tracker.domain.resource;

import javax.inject.Inject;
import tracker.core.resource.BaseResourceImpl;
import tracker.core.service.BaseService;
import tracker.domain.entity.User;
import tracker.domain.service.UserService;

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