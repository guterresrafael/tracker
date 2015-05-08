package rs.pelotas.tracker.repository;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public class DeviceRepository extends BaseRepository<Device, Long> implements Repository<Device, Long> {

    public List<Device> findDevicesByUserId(Long userId) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Device> criteriaQuery = criteriaBuilder.createQuery(Device.class);
        Root<Device> root = criteriaQuery.from(Device.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("user.id"), userId));
        TypedQuery typedQuery = getEntityManager().createQuery(criteriaQuery);
        List<Device> devices = typedQuery.getResultList();
        return devices;
    }
}
