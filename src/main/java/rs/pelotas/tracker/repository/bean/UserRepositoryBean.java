package rs.pelotas.tracker.repository.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.entity.Device_;
import rs.pelotas.tracker.entity.User;
import rs.pelotas.tracker.repository.UserRepository;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public class UserRepositoryBean extends BaseRepository<User, Long> implements UserRepository {

    private static final long serialVersionUID = -5110859541451047877L;

    @Override
    public List<User> findUsersByDeviceId(Long deviceId) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<Device> deviceRoot = criteriaQuery.from(Device.class);
        criteriaQuery.where(criteriaBuilder.equal(deviceRoot.get(Device_.id), deviceId));
        ListJoin<Device, User> users = deviceRoot.join(Device_.users);
        CriteriaQuery<User> cq = criteriaQuery.select(users);
        TypedQuery<User> typedQuery = getEntityManager().createQuery(cq);
        return typedQuery.getResultList();
    }
}
