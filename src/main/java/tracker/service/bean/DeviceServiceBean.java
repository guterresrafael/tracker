package tracker.service.bean;

import arch.repository.Repository;
import arch.service.BaseService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tracker.entity.Device;
import tracker.repository.DeviceRepository;
import tracker.service.DeviceService;

/**
 * @author Rafael Guterres
 */
@Stateless
public class DeviceServiceBean extends BaseService<Device, Long> implements DeviceService {

    private static final long serialVersionUID = -6173900068176198955L;

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
