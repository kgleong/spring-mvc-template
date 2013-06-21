package com.orangemako.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Application Context Configuration.
 *
 * @author Kevin Leong
 */
@Configuration // Identifies this class to Spring as a configuration file
public class ApplicationConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

    /**
     * HSQL embedded database that loads a schema from a SQL file then populates the database with sample data.
     *
     * @return
     */
    @Bean
    EmbeddedDatabase embeddedDatabase() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase database = builder
                                        .setType(EmbeddedDatabaseType.HSQL)
                                        .addScript("persistence/schema.sql")
                                        .addScript("persistence/sample-data.sql").build();
        return database;
    }
}
