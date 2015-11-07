package rs.pelotas.tracker.service;

import java.util.List;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
public interface UserService extends Service<User, Long> {

    User findByLogin(String login);

    List<User> findUsersByDevicesId(Long deviceId);
}
