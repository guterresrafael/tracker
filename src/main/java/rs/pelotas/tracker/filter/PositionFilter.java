package rs.pelotas.tracker.filter;

import rs.pelotas.arch.repository.Filter;
import rs.pelotas.arch.repository.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
public class PositionFilter implements Filter {
    
    @CriteriaFilter
    private Long deviceId;
    
    
    
    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
    
}
