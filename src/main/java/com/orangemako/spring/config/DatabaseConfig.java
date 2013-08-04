package com.orangemako.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Database Configuration.
 *
 * @author Kevin Leong
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.orangemako.spring.repository")
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

    @Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(remoteDatabase());
        entityManagerFactoryBean.setPersistenceUnitName("spring-jpa");
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());

        return entityManagerFactoryBean;
    }

    @Bean
    HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(Database.MYSQL);

        return jpaVendorAdapter;
    }

    @Bean
    JpaTransactionManager transactionManager() throws PropertyVetoException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return transactionManager;
    }

    /**
     * Read in properties from property files.
     * @return
     */
    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return ConfigUtils.propertySourcesPlaceholderConfigurer();
    }
}
