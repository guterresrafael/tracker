package org.traccar.repository;

import arch.repository.Repository;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.traccar.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public class DeviceRepository extends BaseTraccarRepository<Device, Long> implements Repository<Device, Long> {

    private static final long serialVersionUID = 5330144509499505026L;

    public List<Device> findDevicesByUserId(Long userId) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Device> criteriaQuery = criteriaBuilder.createQuery(Device.class);
        Root<Device> root = criteriaQuery.from(Device.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(root.get("user.id"), userId));
        TypedQuery typedQuery = getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
