package tracker.domain.service;

import javax.inject.Inject;
import tracker.core.repository.BaseRepository;
import tracker.core.service.BaseServiceImpl;
import tracker.domain.entity.Device;
import tracker.domain.repository.DeviceRepository;

/**
 * @author Rafael Guterres
 */
public class DeviceServiceImpl
     extends BaseServiceImpl<Device, Long> 
  implements DeviceService {
    
    @Inject
    DeviceRepository deviceRepository;

    @Override
    public BaseRepository<Device, Long> getRepository() {
        return deviceRepository;
    }
}