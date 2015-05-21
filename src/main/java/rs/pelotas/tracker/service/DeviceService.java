package rs.pelotas.tracker.service;

import javax.ejb.Stateless;
import rs.pelotas.arch.service.Service;
import rs.pelotas.tracker.entity.Device;

/**
 *
 * @author Rafael Guterres
 */
@Stateless
public interface DeviceService extends Service<Device, Long> {
    
}