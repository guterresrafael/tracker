package tracker.domain.resource;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import tracker.domain.entity.Device;
import tracker.domain.filter.DeviceFilter;
import tracker.domain.service.DeviceService;

/**
 * 
 * @author Rafael Guterres
 */
@Path("/devices")
public class DeviceResource {

    @Inject
    DeviceService deviceService;
    
    @PermitAll
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getDevices() {
        List<Device> devices = deviceService.findAll();
        if (devices.isEmpty()) {
            //TODO: Implementar NotFound
        }
        return devices;
    }
    
    @PermitAll
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device getDeviceById(@PathParam("id") Long id) {
        Device device = deviceService.load(id);
        if (device == null) {
            //TODO: Implementar NotFound
        }
        return device;
    }
    
    @PermitAll
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getDevicesByFilter(@QueryParam("imei") String imei,
                                           @QueryParam("name") String name) {
        DeviceFilter deviceFilter = new DeviceFilter();
        deviceFilter.setImei(imei);
        deviceFilter.setName(name); 
        List<Device> devices = deviceService.findByFilter(deviceFilter);
        if (devices.isEmpty()) {
            //TODO: Implementar NotFound
        }
        return devices;
    }
}