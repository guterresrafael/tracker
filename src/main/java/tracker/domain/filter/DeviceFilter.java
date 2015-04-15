package tracker.domain.filter;

import tracker.core.filter.BaseFilter;
import tracker.core.annotation.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
public class DeviceFilter extends BaseFilter {
    
    @CriteriaFilter
    private String name;
    
    @CriteriaFilter
    private String imei;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
