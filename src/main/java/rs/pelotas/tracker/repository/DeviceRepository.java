package rs.pelotas.tracker.repository;

import java.util.List;
import rs.pelotas.arch.repository.BaseRepository;
import rs.pelotas.tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public interface DeviceRepository extends BaseRepository<Device, Long> {
    
    public List<Device> findDevicesByUserId(Long userId);
}
