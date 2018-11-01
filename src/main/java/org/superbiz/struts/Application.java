package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2FilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FilterDispatcher());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("actionPackages", "com.lq");
        registration.setName("struts2");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean strutsCleanupFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ActionContextCleanUp());
        registration.addUrlPatterns("/*");
        registration.setName("struts-cleanup");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PageFilter());
        registration.addUrlPatterns("/*");
        registration.setName("sitemesh");
        registration.setOrder(3);
        return registration;
    }

}
