package org.traccar.service;

import arch.repository.Repository;
import arch.service.BaseService;
import arch.service.Service;
import java.util.List;
import javax.inject.Inject;
import org.traccar.entity.User;
import tracker.filter.UserFilter;
import org.traccar.repository.UserRepository;

/**
 *
 * @author Rafael Guterres
 */
public class UserService extends BaseService<User, Long> implements Service<User, Long> {

    private static final long serialVersionUID = -8063860493524059545L;

    @Inject
    private UserRepository userRepository;

    @Override
    public Repository<User, Long> getRepository() {
        return userRepository;
    }

    public User findByLogin(String login) {
        UserFilter userFilter = new UserFilter();
        userFilter.setLogin(login);
        List<User> users = userRepository.find(userFilter);
        return users.get(0);
    }
}
