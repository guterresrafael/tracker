package rs.pelotas.tracker.repository.bean;

import javax.ejb.Stateless;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.repository.UserRepository;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public class UserRepositoryBean extends BaseRepository<User, Long> implements UserRepository {
    
    private static final long serialVersionUID = -5110859541451047877L;
}