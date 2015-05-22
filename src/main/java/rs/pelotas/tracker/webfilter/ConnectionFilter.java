package rs.pelotas.tracker.webfilter;

import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
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

    @Inject
    Logger logger;
    
    @Resource
    UserTransaction userTransaction;

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            userTransaction.begin();
            chain.doFilter(request, response);
            userTransaction.commit();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    public void destroy() {
    }
}