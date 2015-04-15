package tracker.core.filter;

import java.io.Serializable;

/**
 *
 * @author Rafael Guterres
 */
public class BaseFilter implements Serializable {
    
    private Integer maxResults;

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}