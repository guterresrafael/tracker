package rs.pelotas.tracker.service;

import javax.ejb.Stateful;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Stateful
public interface UserService extends Service<User, Long> {

    User findByLogin(String login);
}