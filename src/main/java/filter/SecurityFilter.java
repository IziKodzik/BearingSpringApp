package filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.AdminService;
import service.SecurityService;
import service.UserService;
import service.implementation.SecurityServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@ComponentScan({"service"})
@WebFilter(filterName = "AuthFilter",urlPatterns = {"/user/*","/admin/*"})
//@Order(1)
public class SecurityFilter
    implements Filter {

    SecurityService securityService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.initializeServices(filterConfig);

    }

    @Override
    public void doFilter(ServletRequest servletRequest
            , ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("FILTRU");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }

    private void initializeServices(FilterConfig filterConfig) {
        if(securityService==null){
            securityService = WebApplicationContextUtils
                    .getRequiredWebApplicationContext(filterConfig.getServletContext()).
                            getBean(SecurityServiceImpl.class);
        }

    }
}
