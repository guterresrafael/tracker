package tracker.repository;

import arch.repository.Repository;
import java.util.List;
import tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
public interface UserRepository extends Repository<User, Long> {

    List<User> findUsersByDeviceId(Long deviceId);
}
