package org.traccar.service;

import java.util.List;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import org.traccar.entity.User;
import rs.pelotas.tracker.filter.UserFilter;
import org.traccar.repository.UserRepository;

/**
 *
 * @author Rafael Guterres
 */
public class UserService extends BaseService<User, Long> implements Service<User, Long> {
    
    @Inject
    UserRepository userRepository;

    @Override
    public Repository<User, Long> getRepository() {
        return userRepository;
    }
    
    public User findByLogin(String login) {
        UserFilter userFilter = new UserFilter();
        userFilter.setLogin(login);
        List<User> users = userRepository.findByFilter(userFilter);
        return users.get(0);
    }
    
    public boolean isUserAuthenticated(String username, String passsword) {
        User user = this.findByLogin(username);
        return user != null && 
               user.getPassword() != null &&
               user.getPassword().equals(passsword);
    }
    
    public boolean isUserAuthorizated(String username, String role) {
        return true;
    }
}