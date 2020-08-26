package config;
import filters.AuthFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


public class AppInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{new AuthFilter()};
//    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
