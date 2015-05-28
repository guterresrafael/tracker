package rs.pelotas.tracker.repository;

import java.util.List;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
public interface UserRepository extends Repository<User, Long> {
 
    List<User> findUsersByDeviceId(Long deviceId);
}
