package rs.pelotas.tracker.repository;

import java.util.List;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public interface DeviceRepository extends Repository<Device, Long> {

    List<Device> findDevicesByUserId(Long userId);
}
