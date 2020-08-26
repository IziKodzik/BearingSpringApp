package filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter",urlPatterns = {"/user/*","/admin/*"})
public class AuthFilter
    implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest
            , ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        servletResponse.getWriter().write("FUCK");

    }

    @Override
    public void destroy() {

    }
}
