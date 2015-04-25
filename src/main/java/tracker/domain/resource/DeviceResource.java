package tracker.domain.resource;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tracker.domain.entity.Device;
import tracker.domain.filter.DeviceFilter;
import tracker.domain.service.DeviceService;

/**
 * 
 * @author Rafael Guterres
 */
@Path("/devices")
@RequestScoped
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
            throw new WebApplicationException(Response.Status.NOT_FOUND);
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
            throw new WebApplicationException(Response.Status.NOT_FOUND);
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
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return devices;
    }
}