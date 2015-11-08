package tracker.service;

import arch.service.Service;
import java.util.List;
import tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
public interface UserService extends Service<User, Long> {

    User findByLogin(String login);

    List<User> findUsersByDevicesId(Long deviceId);
}
