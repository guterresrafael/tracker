package rs.pelotas.tracker.service.bean;

import java.util.List;
import javax.inject.Inject;
import rs.pelotas.arch.repository.Repository;
import rs.pelotas.arch.service.BaseService;
import rs.pelotas.tracker.entity.Device;
import rs.pelotas.tracker.repository.DeviceRepository;
import rs.pelotas.tracker.service.DeviceService;

/**
 * @author Rafael Guterres
 */
public class DeviceServiceBean extends BaseService<Device, Long> implements DeviceService {

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