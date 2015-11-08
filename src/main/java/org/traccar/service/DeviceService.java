package org.traccar.service;

import arch.repository.Repository;
import arch.service.BaseService;
import arch.service.Service;
import java.util.List;
import javax.inject.Inject;
import org.traccar.entity.Device;
import org.traccar.repository.DeviceRepository;

/**
 * @author Rafael Guterres
 */
public class DeviceService extends BaseService<Device, Long> implements Service<Device, Long> {

    private static final long serialVersionUID = -271039355862815425L;

    @Inject
    private DeviceRepository deviceRepository;

    @Override
    public Repository<Device, Long> getRepository() {
        return deviceRepository;
    }

    public List<Device> findDevicesByUserId(Long userId) {
        return deviceRepository.findDevicesByUserId(userId);
    }
}
