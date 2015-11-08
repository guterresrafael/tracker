package tracker.service.bean;

import arch.repository.Repository;
import arch.service.BaseService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tracker.filter.UserFilter;
import tracker.entity.User;
import tracker.repository.UserRepository;
import tracker.service.UserService;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public class UserServiceBean extends BaseService<User, Long> implements UserService {

    private static final long serialVersionUID = -8808714191503203114L;

    @Inject
    private UserRepository userRepository;

    @Override
    public Repository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByLogin(String login) {
        UserFilter userFilter = new UserFilter();
        userFilter.setLogin(login);
        List<User> users = userRepository.find(userFilter);
        return users.get(0);
    }

    @Override
    public List<User> findUsersByDevicesId(Long deviceId) {
        return userRepository.findUsersByDeviceId(deviceId);
    }
}
