package tracker.domain.repository;

import tracker.core.repository.TrackerRepositoryImpl;
import tracker.domain.entity.User;

/**
 *
 * @author Rafael Guterres
 */
public class UserRepositoryImpl
     extends TrackerRepositoryImpl<User, Long> 
  implements UserRepository {

}
