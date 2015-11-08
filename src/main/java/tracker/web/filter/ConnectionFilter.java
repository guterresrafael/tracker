package tracker.web.filter;

import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.transaction.UserTransaction;

/**
 *
 * @author Rafael Guterres
 */
@WebFilter("/api/*")
public class ConnectionFilter implements Filter {

    @Resource
    private UserTransaction userTransaction;

    @Override
    public void init(FilterConfig fc) throws ServletException {
        //Do nothing.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            userTransaction.begin();
            chain.doFilter(request, response);
            userTransaction.commit();
        } catch (Exception e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        //Do nothing.
    }
}
