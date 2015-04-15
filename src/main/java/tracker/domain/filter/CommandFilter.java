package tracker.domain.filter;

import tracker.core.filter.BaseFilter;
import tracker.core.annotation.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
public class CommandFilter extends BaseFilter {

    @CriteriaFilter
    private Long deviceId;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}