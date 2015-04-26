package tracker.core.filter;

import java.io.Serializable;

/**
 *
 * @author Rafael Guterres
 */
public class BaseFilter implements Serializable {

    private Integer offset = 0;
    private Integer limit = 20;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}