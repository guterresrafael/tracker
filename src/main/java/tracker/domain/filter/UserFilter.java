package tracker.domain.filter;

import tracker.core.filter.BaseFilter;
import tracker.core.annotation.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
@CriteriaFilter
public class UserFilter extends BaseFilter {
    
    private String login;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
