package rs.pelotas.tracker.service;

import java.util.List;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
public interface DeviceService extends BaseService<Device, Long> {

    List<Device> findDevicesByUserId(Long userId);
}