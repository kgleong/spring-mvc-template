package com.orangemako.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Application Context Configuration.
 *
 * @author Kevin Leong
 */
@Configuration // Identifies this class to Spring as a configuration file
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = {"com.orangemako.spring.service"}) // Scans the following packages for classes with @Component annotations
public class ApplicationConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

    /**
     * Read in properties from property files.
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return ConfigUtils.propertySourcesPlaceholderConfigurer();
    }
}
