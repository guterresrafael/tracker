package rs.pelotas.tracker.repository;

import javax.ejb.Stateful;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
@Stateful
public interface UserRepository extends Repository<User, Long> {
    
}
