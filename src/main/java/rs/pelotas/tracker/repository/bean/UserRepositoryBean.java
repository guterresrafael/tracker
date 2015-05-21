package rs.pelotas.tracker.repository.bean;

import javax.enterprise.context.ApplicationScoped;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.repository.UserRepository;

/**
 *
 * @author Rafael Guterres
 */
@ApplicationScoped
public class UserRepositoryBean extends BaseRepository<User, Long> implements UserRepository {
    
    private static final long serialVersionUID = -5110859541451047877L;
}