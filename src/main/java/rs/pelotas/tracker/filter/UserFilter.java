package rs.pelotas.tracker.filter;

import rs.pelotas.arch.filter.BaseFilter;
import rs.pelotas.arch.annotation.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
@CriteriaFilter
public class UserFilter implements BaseFilter {
    
    private String login;
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
