package com.orangemako.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
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
// Marks this class as containing beans to add to the applicable context.
@Configuration

// When added to an @Configuration annotated class, this imports WebMvcConfigurationSupport, which
// maps requests to @RequestMapping annotated methods/classes as well as registering other mapping handlers.
@EnableWebMvc

// Import beans or other configurations from an XML file.
@ImportResource("classpath:dispatcher_config.xml")

// Scans the following packages for classes with @Component annotations
@ComponentScan(basePackages = {"com.orangemako.spring.controller", "com.orangemako.spring.aop"})
public class DispatcherConfig extends WebMvcConfigurerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(DispatcherConfig.class);

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
        resourceList.add(new FileSystemResource(
                System.getProperty("user.home") + "/.spring/spring-mvc-template.properties"));

        org.springframework.core.io.Resource[] resources =
                resourceList.toArray(new org.springframework.core.io.Resource[resourceList.size()]);
        rval.setLocations(resources);

        // Ignore errors if property files can't be found (for optional property files)
        rval.setIgnoreResourceNotFound(true);
        return rval;
    }
}