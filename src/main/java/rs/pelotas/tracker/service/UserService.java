package rs.pelotas.tracker.service;

import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
public interface UserService extends Service<User, Long> {

    User findByLogin(String login);
}