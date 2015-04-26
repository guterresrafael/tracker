package tracker.core.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Rafael Guterres
 */
public class QueryParams {
    
    private static final String SORT_KEY_PARAM = "sort";
    
    private static final String FIELDS_KEY_PARAM = "fields";
    
    private static final String OFFSET_KEY_PARAM = "offset";
    private static final Integer OFFSET_DEFAULT_VALUE = 0;
    
    private static final String LIMIT_KEY_PARAM = "limit";
    
    private List<String> sort = new ArrayList<>();
    private List<String> fields = new ArrayList<>();
    private Integer offset;
    private Integer limit;

    public QueryParams() {
    }

    public QueryParams(HttpServletRequest request) {
        setOffset(request.getParameter(OFFSET_KEY_PARAM));
        setLimit(request.getParameter(LIMIT_KEY_PARAM));
        setSort(request.getParameter(SORT_KEY_PARAM));
        setFields(request.getParameter(FIELDS_KEY_PARAM));
    }
    
    public List<String> getSort() {
        return sort;
    }

    public void setSort(List<String> sort) {
        this.sort = sort;
    }
    
    private void setSort(String sort) {
        if (sort != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(sort, ",");
            while(stringTokenizer.hasMoreTokens()) {
                this.sort.add(stringTokenizer.nextToken());
            }
        }
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }
    
    private void setFields(String fields) {
        if (fields != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(fields, ",");
            while(stringTokenizer.hasMoreTokens()) {
                this.fields.add(stringTokenizer.nextToken());
            }
        }
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    private void setOffset(String offset) {
        try {
            this.offset = Integer.parseInt(offset);
        } catch (NumberFormatException e) {
            this.offset = OFFSET_DEFAULT_VALUE;
        }
    }
    
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    private void setLimit(String limit) {
        try {
            this.limit = Integer.parseInt(limit);
        } catch (NumberFormatException e) {
            this.limit = null;
        }
    }
}