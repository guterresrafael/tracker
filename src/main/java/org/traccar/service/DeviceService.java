package org.traccar.service;

import java.util.List;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
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
