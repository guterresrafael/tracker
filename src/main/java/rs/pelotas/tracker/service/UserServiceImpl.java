package rs.pelotas.tracker.service;

import java.util.List;
import javax.inject.Inject;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.service.BaseServiceImpl;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.filter.UserFilter;
import rs.pelotas.tracker.repository.UserRepository;

/**
 *
 * @author Rafael Guterres
 */
public class UserServiceImpl 
     extends BaseServiceImpl<User, Long> 
  implements UserService {
    
    @Inject
    UserRepository userRepository;

    @Override
    public BaseRepository<User, Long> getRepository() {
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