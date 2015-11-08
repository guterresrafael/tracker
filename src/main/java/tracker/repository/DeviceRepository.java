package tracker.repository;

import arch.repository.Repository;
import java.util.List;
import tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public interface DeviceRepository extends Repository<Device, Long> {

    List<Device> findDevicesByUserId(Long userId);
}
