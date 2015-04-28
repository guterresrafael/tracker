package rs.pelotas.tracker.filter;

import rs.pelotas.arch.filter.BaseFilter;
import rs.pelotas.arch.annotation.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
public class CommandFilter implements BaseFilter {

    @CriteriaFilter
    private Long deviceId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}