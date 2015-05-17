package rs.pelotas.tracker.security;

import java.util.Set;
import javax.inject.Inject;
import org.traccar.entity.User;
import org.traccar.service.UserService;
import rs.pelotas.arch.security.AuthenticationAndAuthorizationSecurity;

/**
 *
 * @author Rafael Guterres
 */
public class AuthSecurity implements AuthenticationAndAuthorizationSecurity {

    private static final long serialVersionUID = 3060578476342703986L;

    @Inject
    UserService userService;
    
    @Override
    public boolean isAuthenticatedUser(String login, String password) {
        User user = userService.findByLogin(login);
        return password != null && password.equalsIgnoreCase(user.getPassword());
    }

    @Override
    public boolean isAuthorizedUser(String login, Set<String> roles) {
        return true;
    }
}