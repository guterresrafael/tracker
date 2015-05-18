package rs.pelotas.tracker.security;

import java.util.Set;
import javax.inject.Inject;
import rs.pelotas.arch.security.AuthenticationAndAuthorizationSecurity;
import rs.pelotas.arch.security.AuthorizationBasic;
import rs.pelotas.tracker.entity.Role;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class AuthSecurity implements AuthenticationAndAuthorizationSecurity {

    private static final long serialVersionUID = 3060578476342703986L;

    @Inject
    UserService userService;
    
    @Override
    public boolean isAuthenticatedUser(AuthorizationBasic authorization) {
        try {
            User user = userService.findByLogin(authorization.getUsername());
            if (authorization.getPassword().equalsIgnoreCase(user.getPassword())) {
                for (Role role : user.getRoles()) {
                    authorization.getRoles().add(role.getName());
                }
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean isAuthorizedUser(AuthorizationBasic authorization, Set<String> roles) {
        for (String role : roles) {
            if (authorization.getRoles().contains(role)) {
                return true;
            }
        }
        return false;
    }
}