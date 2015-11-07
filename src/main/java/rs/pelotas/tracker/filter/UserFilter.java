package rs.pelotas.tracker.filter;

import rs.pelotas.arch.repository.Filter;
import rs.pelotas.arch.repository.CriteriaFilter;

/**
 *
 * @author Rafael Guterres
 */
@CriteriaFilter
public class UserFilter implements Filter {

    private static final long serialVersionUID = -826179002987833812L;

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
