package com.car.manage.common.config;

import com.car.manage.common.filter.WrappedServletRequestFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * wrapped servlet.
 */
@Configuration
public class RequestConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(RequestConfiguration.class);

    /**
     * 注册 wrapped servlet.
     *
     * @return wrapped servlet
     */
    @Bean
    public FilterRegistrationBean wrappedServlet() {
        LOG.info("注册 wrapped servlet");
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        WrappedServletRequestFilter filter = new WrappedServletRequestFilter();
        filterRegistration.setFilter(filter);

        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return filterRegistration;
    }
}
