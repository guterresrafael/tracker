package tracker.resource.bean;

import arch.security.UserPrincipal;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import tracker.entity.User;
import tracker.resource.AccountResource;
import tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class AccountResourceBean implements AccountResource {

    private static final long serialVersionUID = -3491249668209753237L;

    @Inject
    private UserService userService;

    @Context
    private SecurityContext securityContext;

    @Override
    public User getAccount() {
        UserPrincipal userPrincipal = (UserPrincipal) securityContext.getUserPrincipal();
        return userService.load(userPrincipal.getId());
    }
}
