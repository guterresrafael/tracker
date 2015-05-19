package rs.pelotas.tracker.service;

import java.util.List;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.repository.DeviceRepository;

/**
 * @author Rafael Guterres
 */
public class DeviceService extends BaseService<Device, Long> implements Service<Device, Long> {

    private static final long serialVersionUID = -6173900068176198955L;

    @Inject
    DeviceRepository deviceRepository;

    @Override
    public Repository<Device, Long> getRepository() {
        return deviceRepository;
    }

    public List<Device> findDevicesByUserId(Long userId) {
        return deviceRepository.findDevicesByUserId(userId);
    }
}