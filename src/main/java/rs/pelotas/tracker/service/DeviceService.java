package rs.pelotas.tracker.service;

import java.util.List;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public interface DeviceService extends Service<Device, Long> {

    List<Device> findDevicesByUserId(Long userId);
}
