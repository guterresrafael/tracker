package rs.pelotas.tracker.repository;

import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.User;

/**
 *
 * @author Rafael Guterres
 */
public class UserRepository extends BaseRepository<User, Long> implements Repository<User, Long> {
    
    private static final long serialVersionUID = -5110859541451047877L;
}