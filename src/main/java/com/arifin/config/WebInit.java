package com.arifin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by etos on 10/31/2016.
 */
@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = {
                new CORSFilter()
                //new AuthenticationTokenFilter()
        };
        return singleton;
    }
}
