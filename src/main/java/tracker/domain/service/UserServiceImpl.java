package tracker.domain.service;

import java.util.List;
import javax.inject.Inject;
import tracker.core.repository.BaseRepository;
import tracker.core.service.BaseServiceImpl;
import tracker.domain.entity.User;
import tracker.domain.filter.UserFilter;
import tracker.domain.repository.UserRepository;

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