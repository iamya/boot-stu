package com.iamya.boot.crud.config;

import com.iamya.boot.crud.web.HelloFilter;
import com.iamya.boot.crud.web.HelloListener;
import com.iamya.boot.crud.web.HelloServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean helloServlet() {
        ServletRegistrationBean<HelloServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new HelloServlet());
        bean.setUrlMappings(Arrays.asList("/helloServlet"));
        return bean;
    }

    @Bean
    public FilterRegistrationBean helloFilter() {
        FilterRegistrationBean<HelloFilter> registryBean = new FilterRegistrationBean<>();
        registryBean.setFilter(new HelloFilter());
        registryBean.setUrlPatterns(Arrays.asList("/", "/helloServlet"));
        return registryBean;
    }

    @Bean
    public ServletListenerRegistrationBean helloListener() {
        ServletListenerRegistrationBean<HelloListener> registrationBean = new ServletListenerRegistrationBean<HelloListener>();
        registrationBean.setListener(new HelloListener());
        return registrationBean;
    }

}
