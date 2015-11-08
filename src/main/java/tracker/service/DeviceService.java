package tracker.service;

import arch.service.Service;
import java.util.List;
import tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public interface DeviceService extends Service<Device, Long> {

    List<Device> findDevicesByUserId(Long userId);
}
