package rs.pelotas.tracker.resource.bean;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import rs.pelotas.arch.security.UserPrincipal;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.resource.AccountResource;
import rs.pelotas.tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
public class AccountResourceBean implements AccountResource {

    private static final long serialVersionUID = -3491249668209753237L;

    @Inject
    UserService userService;
    
    @Context
    SecurityContext securityContext;
    
    @Override
    public User getAccount() {
        UserPrincipal userPrincipal = (UserPrincipal) securityContext.getUserPrincipal();
        return userService.load(userPrincipal.getId());
    }   
}