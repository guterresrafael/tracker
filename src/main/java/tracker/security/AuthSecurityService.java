package tracker.security;

import arch.security.SecurityService;
import arch.security.UserPrincipal;
import java.util.Set;
import javax.inject.Inject;
import tracker.entity.Role;
import tracker.entity.User;
import tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class AuthSecurityService implements SecurityService {

    private static final long serialVersionUID = 3060578476342703986L;

    @Inject
    private UserService userService;

    @Override
    public boolean isAuthenticatedUser(UserPrincipal userPrincipal) {
        if (userPrincipal.getName() != null
            && userPrincipal.getPassword() != null) {
            User user = userService.findByLogin(userPrincipal.getName());
            if (user != null && userPrincipal.getPassword().equalsIgnoreCase(user.getPassword())) {
                userPrincipal.setId(user.getId());
                for (Role role : user.getRoles()) {
                    userPrincipal.getRoles().add(role.getName());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAuthorizedUser(UserPrincipal userPrincipal, Set<String> roles) {
        for (String role : roles) {
            if (userPrincipal.getRoles().contains(role)) {
                return true;
            }
        }
        return false;
    }
}
