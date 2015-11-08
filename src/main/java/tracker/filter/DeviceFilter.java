package tracker.filter;

import arch.repository.CriteriaFilter;
import arch.repository.Filter;

/**
 *
 * @author Rafael Guterres
 */
public class DeviceFilter implements Filter {

    private static final long serialVersionUID = -2816539253666022760L;

    @CriteriaFilter
    private Long id;

    @CriteriaFilter
    private String name;

    @CriteriaFilter
    private String imei;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
