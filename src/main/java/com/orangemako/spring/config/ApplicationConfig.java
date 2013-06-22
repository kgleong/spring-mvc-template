package com.orangemako.spring.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@MapperScan(basePackages = {"com.orangemako.spring.persistence.dao"}) // Scans the specified package(es) for MyBatis mapper interfaces.
@ComponentScan(basePackages = {"com.orangemako.spring.service"}) // Scans the following packages for classes with @Component annotations
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

    /**
     * Pass the database connection to MyBatis
     * @return
     * @throws Exception
     */
    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(embeddedDatabase());

        return factoryBean.getObject();
    }
}
