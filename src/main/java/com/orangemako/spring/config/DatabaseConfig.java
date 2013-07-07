package com.orangemako.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Database Configuration.
 *
 * @author Kevin Leong
 */
@Configuration
public class DatabaseConfig {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);

    // JDBC Connection values from property file(s)
    @Value("${jdbc.driver}")
    String jdbcDriver;

    @Value("${jdbc.url}")
    String jdbcUrl;

    @Value("${jdbc.username}")
    String jdbcUsername;

    @Value("${jdbc.password}")
    String jdbcPassword;

    // Database pool configuration
    @Value("${db.max.pool.size}")
    int maxPoolSize;

    @Value("${db.min.pool.size}")
    int minPoolSize;

    @Value("${db.max.statements.per.connection}")
    int maxStatementsPerConnection;

    @Value("${db.acquire.retry.attempts}")
    int acquireRetryAttempts;

    @Value("${db.acquire.retry.delay}")
    int acquireRetryDelay;

    /**
     * Setup a pooled database connection with a remote database.
     *
     * @return
     */
    DataSource remoteDatabase() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);

        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setMaxStatementsPerConnection(maxStatementsPerConnection);

        dataSource.setAcquireRetryAttempts(acquireRetryAttempts);
        dataSource.setAcquireRetryDelay(acquireRetryDelay);

        return dataSource;
    }

    /**
     * Pass the database connection to MyBatis
     * @return
     * @throws Exception
     */
    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(remoteDatabase());

        return factoryBean.getObject();
    }

    /**
     * Read in properties from property files.
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return ConfigUtils.propertySourcesPlaceholderConfigurer();
    }
}
