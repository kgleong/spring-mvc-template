package com.orangemako.spring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Application Context Configuration.
 *
 * @author Kevin Leong
 */
@Configuration // Identifies this class to Spring as a configuration file
@Import(DatabaseConfig.class) // Import other context files for dependencies
@MapperScan(basePackages = {"com.orangemako.spring.dao"}) // Scans the specified package(es) for MyBatis mapper interfaces.
@ComponentScan(basePackages = {"com.orangemako.spring.service"}) // Scans the following packages for classes with @Component annotations
@ImportResource({"classpath:security-context.xml"}) // Import in any necessary context files.  E.g., Spring Security context.
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
