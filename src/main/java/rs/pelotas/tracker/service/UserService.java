package rs.pelotas.tracker.service;

import java.util.List;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.filter.UserFilter;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.repository.UserRepository;

/**
 *
 * @author Rafael Guterres
 */
public class UserService extends BaseService<User, Long> implements Service<User, Long> {

    private static final long serialVersionUID = -8808714191503203114L;
    
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
}