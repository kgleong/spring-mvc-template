package com.orangemako.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * MVC Servlet Context Configuration.
 *
 * @author Kevin Leong
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.orangemako.spring.controller"}) // Scans the following packages for classes with @Controller annotations
public class MvcContext extends WebMvcConfigurerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(MvcContext.class);

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * Provide a view resolver to map views to the correct template files.
     *
     * @return
     */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/jsp/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    /**
     * Read in properties from property files.
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer rval = new PropertySourcesPlaceholderConfigurer();

        // Add the property files to the resource list
        List<org.springframework.core.io.Resource> resourceList = new ArrayList<org.springframework.core.io.Resource>();

        // Internal property file
        resourceList.add(new ClassPathResource("default-config.properties"));

        // External optional property file that can override properties in the internal property file.
        resourceList.add(new FileSystemResource(System.getProperty("user.home") + "/.spring/spring-mvc-template.properties"));

        org.springframework.core.io.Resource[] resources = resourceList.toArray(new org.springframework.core.io.Resource[resourceList.size()]);
        rval.setLocations(resources);

        // Ignore errors if property files can't be found (for optional property files)
        rval.setIgnoreResourceNotFound(true);
        return rval;
    }
}
