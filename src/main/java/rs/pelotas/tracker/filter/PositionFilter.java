package rs.pelotas.tracker.filter;

import rs.pelotas.arch.repository.Filter;
import rs.pelotas.arch.repository.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
public class PositionFilter implements Filter {

    private static final long serialVersionUID = 2541133153834424892L;

    @CriteriaFilter
    private Long deviceId;
    
    
    
    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
    
}
