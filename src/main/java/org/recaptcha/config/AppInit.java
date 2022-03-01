package org.recaptcha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

@PropertySource("classpath:application.properties")
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Value("${meta.charset}")
    private String defaultEncoding;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { Config.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding(defaultEncoding);
        filter.setForceEncoding(true);
        HiddenHttpMethodFilter http = new HiddenHttpMethodFilter();
        return new Filter[] { filter, http };
    }

    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        DispatcherServlet dis = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
        dis.setThrowExceptionIfNoHandlerFound(true);
        return dis;
    }
}
