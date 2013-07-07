package com.orangemako.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilities for Configuration classes.
 *
 * @author Kevin Leong
 */
public class ConfigUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigUtils.class);

    /**
     * Read in properties from property files.  This allows for the overriding of the default
     * internal properties file by external property files.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer rval = new PropertySourcesPlaceholderConfigurer();

        // Add the property files to the resource list
        List<Resource> resourceList = new ArrayList<Resource>();

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
